import java.io.*;
import java.util.*;

public class Boxers {
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
        readInt(br);
        int[] a = readArrInt(br);
        System.out.println(getResult(a));
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

    private static int getResult(int[] a) {
        Arrays.sort(a);
        Set<Integer> set = new HashSet<>();
        int end = a[0];
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                if (a[i] > 1) {
                    a[i] = a[i] - 1;
                    end = a[i];
                }
            } else {
                if (end < a[i] - 1) {
                    a[i] = a[i] - 1;
                    end = a[i];
                } else if (end == a[i]) {
                    a[i] = a[i] + 1;
                    end = a[i];
                } else {
                    if (a[i] > end)
                        end = a[i];
                }
            }
            set.add(a[i]);
        }
        return set.size();
    }
}
