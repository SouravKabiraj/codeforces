import java.io.*;
import java.util.*;

public class BinaryStringReconstruction {
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
        String str = br.readLine();
        int x = readInt(br);
        reconstruction(str, x);
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

    private static void reconstruction(String s, int x) {
        char[] w = new char[s.length()];
        String resStr = "";
        Arrays.fill(w, '1');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i - x >= 0) {
                    w[i - x] = '0';
                }
                if (i + x < s.length()) {
                    w[i + x] = '0';
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if ((i - x >= 0 && w[i - x] == '1') || (i + x < s.length() && w[i + x] == '1')) {
                    continue;
                } else {
                    System.out.println("-1");
                    return;
                }
            } else {
                if ((i - x >= 0 && w[i - x] == '1') || (i + x < s.length() && w[i + x] == '1')) {
                    System.out.println("-1");
                    return;
                } else {
                    continue;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.print(w[i]);
        }
        System.out.println();
    }
}

