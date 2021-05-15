import java.io.*;
import java.util.*;

public class GasPipeline {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
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
        int[] N_PipeCost_PillerCost = readArrInt(br);
        int pipeCost = N_PipeCost_PillerCost[1];
        int pillerCost = N_PipeCost_PillerCost[2];
        String inp = br.readLine();
        int[] A = new int[inp.length()];
        for (int i = 0; i < inp.length(); i++) {
            A[i] = inp.charAt(i) - '0';
        }
        // print(A);
        System.out.println(getTotalCost(A, pipeCost, pillerCost));
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

    private static void print(long[][] mat) {
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

    private static void log(String text) {
        System.out.println(text);
    }

    private static long getTotalCost(int[] A, int costOfPipe, int costOfPiller) {
        long MAX = 1000000000000000000L;
        long[][] dp = new long[A.length + 1][2];
        for (int i = 0; i < A.length + 1; i++) {
            dp[i][0] = MAX;
            dp[i][1] = MAX;
        }
        dp[0][0] = (long) costOfPiller;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][0] + costOfPipe + costOfPiller);
                dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][0] + 2 * (costOfPipe + costOfPiller));
                dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + costOfPipe + 2 * costOfPiller);
                dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][1] + 2 * costOfPipe + costOfPiller);
            } else {
                dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + costOfPipe + 2 * costOfPiller);
            }
        }
        return dp[A.length][0];
    }
}

