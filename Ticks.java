import java.io.*;
import java.util.*;

public class Ticks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
        for (int i = n - 1; i >= 0; i--) {
            String inp = br.readLine();
            for (int j = 0; j < m; j++) {
                GRP[i][j] = inp.charAt(j);
            }
        }
        evaluate(nmk[2], GRP);
    }

    private static void evaluate(int k, char[][] grp) {
        for (int i = 0; i < grp.length - k; i++) {
            for (int j = 0; j < grp[0].length; j++) {
                if (grp[i][j] == '.') continue;
                if (j > 0 && j < grp[0].length - 1 && grp[i][j] == '-' && grp[i + 1][j - 1] == '-' && grp[i + 1][j + 1] == '.') {
                    continue;
                }
                if (j > 0 && j < grp[0].length - 1 && grp[i][j] == '-' && grp[i + 1][j - 1] == '.' && grp[i + 1][j + 1] == '-') {
                    continue;
                }
                int shift = 1;
                int size = 0;
                // System.out.println(i + "," + j);
                while (true) {
                    if (i + shift < grp.length && j - shift >= 0 && j + shift < grp[0].length && (grp[i + shift][j - shift] == '-' || grp[i + shift][j - shift] == '*') && (grp[i + shift][j + shift] == '-' || grp[i + shift][j + shift] == '*')) {
                    } else {
                        break;
                    }
                    size++;
                    shift++;
                }

                if (size >= k) {
                    grp[i][j] = '-';
                    shift = 1;
                    size = 0;
                    while (true) {
                        if (i + shift < grp.length && j - shift >= 0 && j + shift < grp[0].length && (grp[i + shift][j - shift] == '-' || grp[i + shift][j - shift] == '*') && (grp[i + shift][j + shift] == '-' || grp[i + shift][j + shift] == '*')) {
                            grp[i + shift][j - shift] = '-';
                            grp[i + shift][j + shift] = '-';
                        } else {
                            break;
                        }
                        size++;
                        shift++;
                    }
                }
            }
        }

//        for (int i = 0; i < grp.length; i++) {
//            for (int j = 0; j < grp[0].length; j++) {
//                System.out.print(grp[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < grp.length; i++) {
            for (int j = 0; j < grp[0].length; j++) {
                if (grp[i][j] == '*') {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}