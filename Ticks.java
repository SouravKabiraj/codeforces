import java.io.*;
import java.util.*;

public class Ticks {
    public static void main(String[] args) throws IOException {
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
        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0];
        int m = nmk[1];
        int k = nmk[2];
        char[][] GRP = new char[n][m];
        for (int i = 0; i < n; i++) {
            String inp = br.readLine();
            for (int j = 0; j < m; j++) {
                GRP[i][j] = inp.charAt(j);
            }
        }
        evaluate(nmk[2], GRP);
    }

    private static void evaluate(int k, char[][] grp) {
        for (int i = k; i < grp.length; i++) {
            for (int j = k; j < grp[0].length; j++) {
                if (grp[i][j] == '.') continue;
                int size = 0;
                for (int d = 1; i - d >= 0 && j - d >= 0 && j + d < grp[0].length; d++) {
                    if ((grp[i - d][j - d] == '*' || grp[i - d][j - d] == '^') && (grp[i - d][j + d] == '*' || grp[i - d][j + d] == '^')) {
                        size++;
                    }
                }
                if (size >= k) {
                    grp[i][j] = '^';
                    for (int d = 1; i - d >= 0 && j - d >= 0 && j + d < grp[0].length; d++) {
                        if ((grp[i - d][j - d] == '*' || grp[i - d][j - d] == '^') && (grp[i - d][j + d] == '*' || grp[i - d][j + d] == '^')) {
                            grp[i - d][j - d] = '^';
                            grp[i - d][j + d] = '^';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < grp.length; i++) {
            for (int j = 0; j < grp[0].length; j++) {
                // System.out.print(grp[i][j]);
                if (grp[i][j] == '*') {
                    System.out.println("NO");
                    return;
                }
            }
            // System.out.println();
        }
        System.out.println("YES");
    }
}