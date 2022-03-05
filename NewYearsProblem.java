import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NewYearsProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            br.readLine();
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] mn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = mn[0];
        int n = mn[1];
        int[][] p = new int[m][n];
        for (int i = 0; i < m; i++) {
            p[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(evaluate(m, n, p));
    }

    private static int evaluate(int m, int n, int[][] p) {
        int max = 0;
        int min = 1000000000;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, p[i][j]);
                min = Math.min(min, p[i][j]);
            }
        }
        // System.out.println("max:" + max);
        // System.out.println("min:" + min);
        while (min < max) {
            int mid = min + (max - min + 1) / 2;
            if (isPossible(m, n, p, mid)) {
                // System.out.println("possible:" + mid);
                min = mid;
            } else {
                // System.out.println("not possible:" + mid);
                max = mid - 1;
            }
        }
        // System.out.println("end max:" + max);
        // System.out.println("end min:" + min);
        return min;
    }

    private static boolean isPossible(int m, int n, int[][] p, int minA) {
        // buy gift for two friends
        int f1 = -1;
        int f2 = -1;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (p[i][j] >= minA) {
                    // System.out.println(i + ":" + j);
                    count++;
                    if (f1 == -1) {
                        f1 = j;
                        // System.out.println(i + ":" + f1 + ":" + f2);
                    } else {
                        f2 = j;
                        // System.out.println(i + ":" + f1 + ":" + f2);
                        break;
                    }
                }
            }
            if (count >= 2) {
                break;
            } else {
                f1 = -1;
                f2 = -1;
            }
        }
        if (f1 == -1 || f2 == -1) return false;

        for (int frnd = 0; frnd < n; frnd++) {
            if (frnd != f1 && frnd != f2) {
                boolean found = false;
                for (int shop = 0; shop < m; shop++) {
                    if (p[shop][frnd] >= minA) {
                        found = true;
                        break;
                    }
                }
                if (!found) return false;
            }
        }
        return true;
    }
}
