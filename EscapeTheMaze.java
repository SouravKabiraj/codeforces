import java.io.*;
import java.util.*;

public class EscapeTheMaze {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            br.readLine();
            int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nk[0];
            int k = nk[1];
            int[] friends = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Set<Integer>> tree = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                int[] uv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (!tree.containsKey(uv[0])) {
                    tree.put(uv[0], new HashSet<>());
                }
                if (!tree.containsKey(uv[1])) {
                    tree.put(uv[1], new HashSet<>());
                }
                tree.get(uv[0]).add(uv[1]);
                tree.get(uv[1]).add(uv[0]);
            }
            evaluate(n, k, friends, tree);
        }
    }

    private static void evaluate(int n, int k, int[] friends, Map<Integer, Set<Integer>> tree) {
        makeUnidirectional(tree, 1);
        int[] burnTime = new int[n + 1];
        int[] heights = new int[n + 1];
        Arrays.fill(burnTime, n);
        for (int i = 0; i < k; i++) {
            burnTime[friends[i]] = 0;
        }
        getBurnTime(tree, 1, friends, burnTime);
        getHeight(tree, 1, heights, 0);
        if (isLeafReachable(tree, 1, burnTime, heights)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void makeUnidirectional(Map<Integer, Set<Integer>> tree, int node) {
        for (int next : tree.get(node)) {
            tree.get(next).remove(node);
            makeUnidirectional(tree, next);
        }
    }

    private static int getBurnTime(Map<Integer, Set<Integer>> tree, int node, int[] friends, int[] burnTime) {
        if (burnTime[node] == 0) {
            return burnTime[node];
        } else if (tree.get(node).size() == 0) {
            return burnTime[node];
        } else {
            int minBurnTime = burnTime[node];
            for (int next : tree.get(node)) {
                minBurnTime = Math.min(minBurnTime, getBurnTime(tree, next, friends, burnTime));
            }
            burnTime[node] = minBurnTime + 1;
            return burnTime[node];
        }
    }

    private static void getHeight(Map<Integer, Set<Integer>> tree, int node, int[] heights, int h) {
        heights[node] = h;
        for (int next : tree.get(node)) {
            getHeight(tree, next, heights, h + 1);
        }
    }

    private static boolean isLeafReachable(Map<Integer, Set<Integer>> tree, int node, int[] burnTime, int[] heights) {
        // System.out.println(node + ": burn:" + burnTime[node] + " height:" + heights[node]);
        if (burnTime[node] <= heights[node]) {
            return false;
        } else {
            if (tree.get(node).size() == 0) {
                return true;
            }
            for (int n : tree.get(node)) {
                if (isLeafReachable(tree, n, burnTime, heights)) return true;
            }
            return false;
        }
    }
}