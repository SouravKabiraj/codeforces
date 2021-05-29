import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VusTheCossackAndNumbers {
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
        int N = readInt(br);
        double[] des = new double[N];
        for (int i = 0; i < N; i++) {
            String inputStr = br.readLine();
            des[i] = Double.valueOf(inputStr);
        }
        getNumbers(des);
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

    private static void getNumbers(double[] nums) {
        int[] result = new int[nums.length];
        double decimalExtras = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 1 == 0) {
                System.out.println((int) nums[i]);
            } else if (nums[i] > 0 && decimalExtras < 0) {
                decimalExtras = decimalExtras + (nums[i] % 1);
                System.out.println((int) nums[i]);
            } else if (nums[i] > 0) {
                decimalExtras = decimalExtras - (1 - (nums[i] % 1));
                System.out.println((int) (nums[i] + 1));
            } else if (nums[i] < 0 && decimalExtras < 0) {
                decimalExtras = decimalExtras + (1 - ((-1 * nums[i]) % 1));
                System.out.println((int) (nums[i] - 1));
            } else {
                decimalExtras = decimalExtras + (nums[i] % 1);
                System.out.println((int) nums[i]);
            }
        }
    }
}

