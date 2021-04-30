import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GoodNumbers {
    public static void main(String[] args) throws Exception {
        // getMinGoodNumber(1000000000000000000L);
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
        long n = readLong(br);
        getMinGoodNumber(n);
    }

    private static int readInt(BufferedReader br) throws Exception {
        return Integer.parseInt(br.readLine());
    }

    private static long readLong(BufferedReader br) throws Exception {
        return Long.valueOf(br.readLine());
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

    private static void getMinGoodNumber(long n) {
        long biggerPow = n;
        long pow = n;
        for (int i = 0; Math.pow(3, i) < n; i++) {
            pow = (long) Math.pow(3, i);
            // System.out.println("- " + pow);
        }
        biggerPow = pow * 3;
        long result = biggerPow;
        long possibleResult = pow;
        for (long i = pow / 3; i > 0; i = i / 3) {
            // System.out.println("> " + (possibleResult + i));
            if (possibleResult + i < n) {
                possibleResult = possibleResult + i;
            } else {
                // System.out.println(">>" + (possibleResult + i));
                result = Math.min(result, (possibleResult + i));
            }
        }
        System.out.println(result);
    }
}
