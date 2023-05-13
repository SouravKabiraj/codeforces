import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TimofeyAndBlackWhiteTree {
    static int minDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] nc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nc[0];
        int c0 = nc[1];
        int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dist = new int[n];
        Arrays.fill(dist, n);
        dist[c0 - 1] = 0;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int[] uv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int u = uv[0];
            int v = uv[1];
            if (!tree.containsKey(u)) {
                tree.put(u, new ArrayList<>());
            }
            if (!tree.containsKey(v)) {
                tree.put(v, new ArrayList<>());
            }
            List<Integer> childrenOfU = tree.get(u);
            List<Integer> childrenOfV = tree.get(v);
            childrenOfU.add(v);
            childrenOfV.add(u);
            tree.put(u, childrenOfU);
            tree.put(v, childrenOfV);
        }
        evaluate(tree, c, n, dist);
    }

    private static void evaluate(Map<Integer, List<Integer>> tree, int[] c, int n, int[] dist) {
        minDist = n;
        for (int i = 0; i < n - 1; i++) {
            if (minDist > 1)
                recalculate(tree, c[i], dist, n);
            System.out.print(minDist + " ");
        }
        System.out.println();
    }

    private static void recalculate(Map<Integer, List<Integer>> tree, int c, int[] dist, int n) {
        dist[c - 1] = 0;
        boolean[] visited = new boolean[n];
        visited[c - 1] = true;

        for (int index = 0; index < tree.get(c).size(); index++) {
            Integer s_index = tree.get(c).get(index);
            calculateDist(tree, s_index, 1, dist, visited);
        }
    }

    private static void calculateDist(Map<Integer, List<Integer>> tree, Integer c, int minDistFromBlack, int[] dist, boolean[] visited) {
        if (visited[c - 1]) return;

        // System.out.println("visiting : " + c + ", dist:" + minDistFromBlack);
        visited[c - 1] = true;

        if (dist[c - 1] == 0) {
            minDist = Math.min(minDist, minDistFromBlack);
            return;
        }
        if (minDistFromBlack >= dist[c - 1]) {
            minDist = Math.min(minDist, (dist[c - 1] + minDistFromBlack));
            return;
        }
        if (dist[c - 1] > minDistFromBlack) {
            dist[c - 1] = minDistFromBlack;
        }
        for (int index = 0; index < tree.get(c).size(); index++) {
            Integer s_index = tree.get(c).get(index);
            calculateDist(tree, s_index, minDistFromBlack + 1, dist, visited);
        }
    }
}