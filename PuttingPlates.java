import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PuttingPlates {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTestCase(br);
    }

    private static void handleMultiTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int H = arr[0];
        int W = arr[1];
        printArrangement(H, W);
    }

    private static void printArrangement(int h, int w) {
        int[][] M = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (isPossible(M, i, j)) {
                    M[i][j] = 1;
                }
            }
        }
        Arrays.stream(M).forEach(ints -> {
            Arrays.stream(ints).forEach(System.out::print);
            System.out.println();
        });
    }

    private static boolean isPossible(int[][] m, int i, int j) {
        if ((i > 0 && i < m.length - 1) && (j > 0 && j < m[0].length - 1)) {
            return false;
        } else {
            if (i > 0 && m[i - 1][j] == 1) return false;
            if (i < m.length - 1 && m[i + 1][j] == 1) return false;
            if (j > 0 && m[i][j - 1] == 1) return false;
            if (j < m[0].length - 1 && m[i][j + 1] == 1) return false;
            if (i > 0 && j < m[0].length - 1 && m[i - 1][j + 1] == 1) return false;
            if (i < m.length - 1 && j > 0 && m[i + 1][j - 1] == 1) return false;
            if (i < m.length - 1 && j < m[0].length - 1 && m[i + 1][j + 1] == 1) return false;
            if (i > 0 && j > 0 && m[i - 1][j - 1] == 1) return false;
            return true;
        }
    }
}