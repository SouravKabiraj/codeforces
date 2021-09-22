import java.io.*;
import java.util.*;

public class Book {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Set<Integer>> dependency = new HashMap<>();
        for (int i = 0; i < N; i++) {
            dependency.put(i + 1, new HashSet<>());
            String[] deps = br.readLine().split(" ");
            for (int k = 1; k < deps.length; k++) {
                dependency.get(i + 1).add(Integer.parseInt(deps[k]));
            }
        }
        readCount(N, dependency);
    }

    private static void readCount(int N, Map<Integer, Set<Integer>> dependency) {
        looped = false;
        Map<Integer, Integer> height = new HashMap<>();
        int maxHeight = 0;
        for (int i = 1; i <= N; i++) {
            int h = calculateHeight(i, dependency, height, N + 1);
            maxHeight = Math.max(maxHeight, h);
        }
        // System.out.println(">> " + height);
        if (looped) {
            System.out.println(-1);
        } else {
            System.out.println(maxHeight);
        }
    }

    private static boolean looped = false;

    private static int calculateHeight(int node, Map<Integer, Set<Integer>> dependency, Map<Integer, Integer> height, int N) {
        if (height.containsKey(node)) return height.get(node);
        if (N == 0) {
            // System.out.println(node + " " + height + " " + N);
            looped = true;
            return 0;
        }
        int maxHeight = 1;
        for (int next : dependency.get(node)) {
            int nextHeight = calculateHeight(next, dependency, height, N - 1);
            maxHeight = Math.max(maxHeight, next < node ? nextHeight : nextHeight + 1);
        }
        height.put(node, maxHeight);
        return maxHeight;
    }
}