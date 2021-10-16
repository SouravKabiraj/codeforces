import java.io.*;
import java.util.*;

public class GardenerAndTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        br.readLine();
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        Map<Integer, Integer> order = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!tree.containsKey(edge[0])) {
                tree.put(edge[0], new HashSet<>());
                order.put(edge[0], 0);
            }
            if (!tree.containsKey(edge[1])) {
                tree.put(edge[1], new HashSet<>());
                order.put(edge[1], 0);
            }
            order.put(edge[0], order.get(edge[0]) + 1);
            order.put(edge[1], order.get(edge[1]) + 1);
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        execute(tree, order, k, n);
    }

    private static void execute(Map<Integer, Set<Integer>> tree, Map<Integer, Integer> order, int k, int n) {
        List<Integer> removals = new ArrayList<>();
        boolean[] removed = new boolean[n + 1];
        for (int i = 1; i <= tree.keySet().size(); i++) {
            if (order.get(i) == 1) {
                removals.add(i);
                removed[i] = true;
            }
        }

        for (int i = 1; i < k && removals.size() > 0; i++) {
            // System.out.println(removals);
            int qSize = removals.size();

            for (int m = 0; m < qSize; m++) {
                int r = removals.get(0);
                for (int next : tree.get(r)) {
                    order.put(next, order.get(next) - 1);
                    if (order.get(next) == 1) {
                        removals.add(next);
                        removed[next] = true;
                        // System.out.println(i + "->" + removed[i]);
                    }
                }
                removals.remove(0);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // System.out.println(i + "->->" + removed[i]);
            if (removed[i] == false) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}