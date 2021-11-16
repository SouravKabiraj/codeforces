import java.io.*;
import java.util.*;

public class RobotOnTheBoard1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = br.readLine();
        evaluate(NM[0], NM[1], input);
    }

    private static void evaluate(int n, int m, String input) {
        int startr = 0;
        int startc = 0;
        int RSize = 1;
        int CSize = 1;
        int r = 0;
        int r1 = 0;
        int r2 = 0;
        int c = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case 'U':
                    r--;
                    break;
                case 'D':
                    r++;
                    break;
                case 'L':
                    c--;
                    break;
                case 'R':
                    c++;
                    break;
            }
            r1 = Math.min(r1, r);
            r2 = Math.max(r2, r);
            c1 = Math.min(c1, c);
            c2 = Math.max(c2, c);
            if ((r2 - r1 + 1) <= n && (c2 - c1 + 1) <= m) {
                RSize = r2 - r1 + 1;
                CSize = c2 - c1 + 1;
                startr = r1;
                startc = c1;
            } else {
                break;
            }
        }
        System.out.println(((-1 * (startr - 1))) + " " + ((-1 * (startc - 1))));
    }
}