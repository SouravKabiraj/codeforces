import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;


public class SubmarineInTheRybinskSea {
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
        String[] line = br.readLine().split(" ");
        getResult(line);
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

    private static void getResult(String[] list) {
        long result = (sumOfSeconds(list) + sumOfFirsts(list)) % 998244353;
        System.out.println(result);
    }

    private static long sumOfSeconds(String[] list) {
        BigInteger modVal = new BigInteger("998244353");
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < list.length; i++) {
            String curr = list[i];
            String resCurr = "";
            for (int j = 0; j < list[0].length(); j++) {
                resCurr = resCurr + "0" + String.valueOf(list[i].charAt(j));
            }
            // System.out.println("->" + resCurr);
            result = new BigInteger(resCurr).mod(modVal).add(result).mod(modVal);
        }
        return result.multiply(BigInteger.valueOf(list.length)).mod(modVal).longValue();
    }

    private static long sumOfFirsts(String[] list) {
        BigInteger modVal = new BigInteger("998244353");
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < list.length; i++) {
            String curr = list[i];
            String resCurr = "";
            for (int j = 0; j < list[0].length(); j++) {
                resCurr = resCurr + String.valueOf(list[i].charAt(j)) + "0";
            }
            // System.out.println("->" + resCurr);
            result = new BigInteger(resCurr).mod(modVal).add(result).mod(modVal);
        }
        return result.multiply(BigInteger.valueOf(list.length)).mod(modVal).longValue();
    }

    private static long function(String a, String b) {
        String result = "";
        for (int i = Math.max(a.length(), b.length()) - 1; i >= 0; i--) {
            String temp = "";
            if (i < a.length()) {
                temp = String.valueOf(a.charAt(i));
            }
            if (i < b.length()) {
                temp = temp + String.valueOf(b.charAt(i));
            }
            result = temp + result;
        }

        long longRes = new BigInteger(result).mod(new BigInteger("998244353")).longValue();
        return longRes;
    }
}

