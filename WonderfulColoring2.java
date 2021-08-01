import java.io.*;
import java.util.*;

public class WonderfulColoring2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = NK[0];
            int K = NK[1];
            int[] ARR = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            color(N, K, ARR);
        }
    }

    private static void color(int n, int k, int[] arr) {
        HashMap<Integer, List<Integer>> eleIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!eleIndex.containsKey(arr[i])) {
                eleIndex.put(arr[i], new ArrayList<>());
            }
            if (eleIndex.get(arr[i]).size() < k)
                eleIndex.get(arr[i]).add(i);
        }
        List<Integer> coloredIndex = new ArrayList<>();
        int[] C = new int[n];
        int color = 1;
        for (int ele : eleIndex.keySet()) {
            List<Integer> indices = eleIndex.get(ele);
            for (int index : indices) {
                C[index] = color;
                coloredIndex.add(index);
                color++;
                if (color == k + 1) color = 1;
            }
        }

        while (C[coloredIndex.get(coloredIndex.size() - 1)] != k) {
            C[coloredIndex.get(coloredIndex.size() - 1)] = 0;
            coloredIndex.remove(coloredIndex.size() - 1);
        }

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.println(C[i]);
            } else {
                System.out.print(C[i] + " ");
            }
        }
    }
}