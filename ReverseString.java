import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    static int[][] right;
    static int[][] left;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            String t = br.readLine();
            boolean ans = find(s, t);
            if (ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean find(String s, String t) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            right = new int[s.length()][t.length()];
            left = new int[s.length()][t.length()];

            if (pathAvailable(s, i, t, 0, true)) {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean pathAvailable(String s, int pointer, String t, int i, boolean direction) {
        count++;
        if (i == t.length()) {
            return true;
        }
        if (pointer < 0 || s.length() <= pointer) {
            return false;
        }
        if (direction && right[pointer][i] != 0) {
            return right[pointer][i] == 1;
        }
        if (!direction && left[pointer][i] != 0) {
            return left[pointer][i] == 1;
        }
        if (s.charAt(pointer) != t.charAt(i)) {
            if (direction) {
                right[pointer][i] = -1;
            } else {
                left[pointer][i] = -1;
            }
            return false;
        } else {
            if (direction) {
                boolean b = pathAvailable(s, pointer + 1, t, i + 1, true) || pathAvailable(s, pointer - 1, t, i + 1, false);
                right[pointer][i] = b ? 1 : -1;
                return b;
            } else {
                boolean b = pathAvailable(s, pointer - 1, t, i + 1, false);
                left[pointer][i] = b ? 1 : -1;
                return b;
            }
        }
    }
}