import java.io.*;
import java.util.*;

public class Portal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        String[] grd = new String[n];
        for (int i = 0; i < n; i++) {
            grd[i] = br.readLine();
        }
        execute(n, m, grd);
    }

    private static void execute(int n, int m, String[] grd) {
        int[][] DP = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                DP[i][j] = (i > 0 ? DP[i - 1][j] : 0) + (j > 0 ? DP[i][j - 1] : 0) - ((i > 0 && j > 0) ? DP[i - 1][j - 1] : 0);
                if (grd[i].charAt(j) == '1') {
                    DP[i][j]++;
                }
            }
        }
        int min = m * n;
        for (int i1 = 1; i1 < n - 3; i1++) {
            for (int j1 = 1; j1 < m - 2; j1++) {
                for (int i2 = i1 + 2; i2 < n - 1; i2++) {
                    for (int j2 = j1 + 1; j2 < m - 1; j2++) {
                        int changes = 0;
                        int inSide = DP[i2][j2] - DP[i1 - 1][j2] - DP[i2][j1 - 1] + DP[i1 - 1][j1 - 1];
                        int rSize = i2 - i1 + 1;
                        int cSize = j2 - j1 + 1;
                        changes = inSide + (2 * rSize + 2 * cSize);
                        int borderi1 = i1 - 2;
                        int borderi2 = i2 + 1;
                        int borderj1 = j1 - 2;
                        int borderj2 = j2 + 1;
                        int extra1 = borderi1 >= 0 ? DP[borderi1][borderj2] : 0;
                        int extra2 = borderj1 >= 0 ? DP[borderi2][borderj1] : 0;
                        int commonDelete = (borderi1 >= 0 && borderj1 >= 0) ? DP[borderi1][borderj1] : 0;
                        // System.out.println(DP[borderi2][borderj2] + " " + commonDelete + " " + extra1 + " " + extra2);
                        int outSide = DP[borderi2][borderj2] + commonDelete - extra1 - extra2 - inSide;
                        outSide -= (grd[borderi1 + 1].charAt(borderj1 + 1) == '1' ? 1 : 0);
                        outSide -= (grd[borderi1 + 1].charAt(borderj2) == '1' ? 1 : 0);
                        outSide -= (grd[borderi2].charAt(borderj2) == '1' ? 1 : 0);
                        outSide -= (grd[borderi2].charAt(borderj1 + 1) == '1' ? 1 : 0);
                        changes = changes - outSide;
                        // System.out.println(i1 + "," + j1 + " " + i2 + "," + j2 + "=" + inSide + " | " + outSide + " ** " + changes);
                        min = Math.min(min, changes);
                    }
                }
            }
        }
        System.out.println(min);
    }
}