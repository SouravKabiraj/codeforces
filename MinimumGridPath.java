import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MinimumGridPath {
    private static long[][][] DP;
    private static long MAX_RESULT = 1000000000000000L;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        int n = readInt(br);
        int[] costs = readArrInt(br);
        System.out.println(getTotalCost(costs, n));
    }

    private static int readInt(BufferedReader br) throws Exception {
        return Integer.parseInt(br.readLine());
    }

    private static int[] readArrInt(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
    }

    private static List<Integer> readList(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
        return arr;
    }

    private static void print(int[][] mat) {
        System.out.println("----------------------------------------");
        for (int i = 0; i < mat.length; i++) {
            System.out.print("{");
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println("----------------------------------------");
    }

    private static void print(int[] mat) {
        System.out.print("{");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println("}");
    }

    private static long getTotalCost(int[] costs, int n) {
        long result = Long.MAX_VALUE;
        long pre = 0;
        List<Integer> XCosts = new ArrayList<>();
        List<Integer> YCosts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                XCosts.add(costs[i]);
            } else {
                YCosts.add(costs[i]);
            }
            pre = pre + costs[i];
            if (i > 0) {
                int Xsize = XCosts.size();
                int Ysize = YCosts.size();
                long XCost = (n - Xsize) * XCosts.get(Xsize - 1);
                long YCost = (n - Ysize) * YCosts.get(Ysize - 1);
                result = Math.min(result, pre + XCost + YCost);
            }
        }
        return result;
    }
}

