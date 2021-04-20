import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class PowerSequence {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTestCase(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        br.readLine();
        int[] arrInt = readArrInt(br);
        System.out.println((long) getMinCost(arrInt));
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

    private static double getMinCost(int[] pow) {
        int n = pow.length;
        Arrays.sort(pow);
        int maxPow = pow[n - 1];
        double minOperation = Double.MAX_VALUE;
        int maxPossibleC = (int) Math.pow(maxPow, 1.0 / (n - 1)) + 1;
        for (int c = 1; c <= maxPossibleC; c++) {
            double totalOps = 0;
            for (int i = 0; i < n; i++) {
                totalOps = totalOps + Math.abs(Math.pow(c, i) - pow[i]);
            }
            if (minOperation > totalOps) {
                minOperation = totalOps;
            }
        }
        return minOperation;
    }
}