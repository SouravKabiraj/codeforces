import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DivideTheStudents {
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
        int[] ints = readArrInt(br);
        System.out.println(getMaxSizeGrp(ints[0], ints[1], ints[2]));
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

    private static int getMaxSizeGrp(int A, int B, int C) {
        int max = Math.max(Math.max(A, B), C);
        int avg = (int) Math.ceil((double) (A + B + C) / 3);

        int low = avg;
        int high = max;

        while (low < high) {
            // System.out.println(low + " " + high);
            int mid = (low + high) / 2;
            if (isPossible(A, B, C, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private static boolean isPossible(int A, int B, int C, int ans) {
        if (A > ans && C > ans) {
            // System.out.println("C1");
            return false;
        } else if (A > ans && (A - ans + B) > ans && (A + B - 2 * ans) > B) {
            // System.out.println("C2");
            return false;
        } else if (C > ans && (C - ans + B) > ans && (C + B - 2 * ans) > B) {
            // System.out.println("C3");
            return false;
        }
        return true;
    }
}

// 1000>667 && (1000 - 667 + 1000)>667 && (1000 + 1000 - 1334) > 666

