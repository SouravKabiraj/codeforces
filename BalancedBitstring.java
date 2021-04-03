import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BalancedBitstring {
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
        int[] nk = readArrInt(br);
        int k = nk[1];
        String str = br.readLine();
        int[] chars = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '1':
                    chars[i] = 1;
                    break;
                case '0':
                    chars[i] = -1;
                    break;
            }
        }
        if (isBalanced(chars, 0, 0, k)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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

    private static boolean isBalanced(int[] chars, int index, int balance, int k) {
        if (index == chars.length) {
            return balance == 0;
        } else {
            if (index < k - 1) {
                if (chars[index] == 0) {
                    chars[index] = 1;
                    boolean AddingOneBalanced = isBalanced(chars, index + 1, balance + 1, k);
                    chars[index] = -1;
                    boolean addingZeroBalanced = isBalanced(chars, index + 1, balance - 1, k);
                    chars[index] = 0;
                    return AddingOneBalanced || addingZeroBalanced;
                } else {
                    return isBalanced(chars, index + 1, balance + chars[index], k);
                }
            } else {
                if (chars[index] == 0) {
                    if (index < k) {
                        chars[index] = 1;
                        boolean AddingOneBalanced = isBalanced(chars, index + 1, balance + chars[index], k);
                        chars[index] = -1;
                        boolean addingZeroBalanced = isBalanced(chars, index + 1, balance + chars[index], k);
                        chars[index] = 0;
                        return AddingOneBalanced || addingZeroBalanced;
                    } else {
                        if (balance != 0) return false;
                        chars[index] = 1;
                        boolean AddingOneBalanced = isBalanced(chars, index + 1, balance + chars[index] - chars[index - k], k);
                        chars[index] = -1;
                        boolean addingZeroBalanced = isBalanced(chars, index + 1, balance + chars[index] - chars[index - k], k);
                        chars[index] = 0;
                        return AddingOneBalanced || addingZeroBalanced;
                    }
                } else {
                    if (index < k) {
                        balance = balance + chars[index];
                        return isBalanced(chars, index + 1, balance, k);
                    } else {
                        if (balance != 0) return false;
                        if (chars[index] != chars[index - k]) {
                            return false;
                        } else {
                            return isBalanced(chars, index + 1, balance, k);
                        }
                    }
                }
            }
        }
    }
}

