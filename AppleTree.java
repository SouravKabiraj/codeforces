import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AppleTree {
    static int[] numberOfLeafs;

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
        int n = Integer.parseInt(br.readLine());
        numberOfLeafs = new int[n + 1];
        Arrays.fill(numberOfLeafs, -1);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int numberOfAssumsions = Integer.parseInt(br.readLine());
        int[][] xys = new int[numberOfAssumsions][2];
        for (int i = 0; i < numberOfAssumsions; i++) {
            xys[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        evaluate(n, graph, xys);
    }

    private static void evaluate(int n, Map<Integer, List<Integer>> graph, int[][] xys) {
        removeParentsLoopBack(graph);
        for (int[] xy : xys) {
            int x = xy[0];
            int y = xy[1];
            int xn = getNumberOfLeafs(graph, x);
            int yn = getNumberOfLeafs(graph, y);
            System.out.println((long) xn * (long) yn);
        }
    }


    // Utility methods
    private static void removeParentsLoopBack(Map<Integer, List<Integer>> graph) {
        for (Integer neighbour : graph.get(1)) {
            removeParents(graph, neighbour, 1);
        }
    }

    private static int getNumberOfLeafs(Map<Integer, List<Integer>> graph, int x) {
        if (numberOfLeafs[x] != -1) {
            return numberOfLeafs[x];
        }
        if (graph.get(x).isEmpty()) {
            numberOfLeafs[x] = 1;
            return 1;
        }
        numberOfLeafs[x] = 0;
        for (Integer child : graph.get(x)) {
            numberOfLeafs[x] = numberOfLeafs[x] + getNumberOfLeafs(graph, child);
        }

        return numberOfLeafs[x];
    }

    private static void removeParents(Map<Integer, List<Integer>> graph, Integer currentNode, Integer parentNode) {
        graph.get(currentNode).remove(parentNode);
        for (Integer child : graph.get(currentNode)) {
            removeParents(graph, child, currentNode);
        }
    }
}