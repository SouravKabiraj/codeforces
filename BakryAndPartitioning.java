import java.io.*;
import java.util.*;

public class BakryAndPartitioning {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1] - 1;
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!tree.containsKey(edge[0])) {
                tree.put(edge[0], new ArrayList<>());
            }
            if (!tree.containsKey(edge[1])) {
                tree.put(edge[1], new ArrayList<>());
            }
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        execute(n, k, tree, a);
    }

    private static boolean flag;

    private static void execute(int n, int k, Map<Integer, List<Integer>> tree, int[] a) {
        flag = false;
        int XOR = a[0];
        for (int i = 1; i < n; i++) {
            XOR = XOR ^ a[i];
        }
        boolean twoCutOnly = k == 1;

        if (XOR == 0) {
            System.out.println("YES");
            return;
        }
        if (!twoCutOnly) {
            getXORSubTree(tree, a, 0, XOR);
            if (flag) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static int getXORSubTree(Map<Integer, List<Integer>> tree, int[] a, int rootIndex, int XOR) {
        if (!flag) {
            int myXOR = a[rootIndex];
            if (tree.containsKey(rootIndex))
                for (int i = 0; i < tree.get(rootIndex).size(); i++) {
                    int next = tree.get(rootIndex).get(i);
                    int nxtXOR = getXORSubTree(tree, a, next, XOR);
                    if (nxtXOR == XOR) {
                        flag = true;
                        return 0;
                    }
                    if ((int) (nxtXOR ^ a[rootIndex]) == XOR) {
                        flag = true;
                        return 0;
                    }
                    myXOR = myXOR ^ nxtXOR;
                }
            if (myXOR == XOR) {
                flag = true;
                return 0;
            }
            return myXOR;
        }
        flag = true;
        return 0;
    }
}