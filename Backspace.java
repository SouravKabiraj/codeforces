import java.io.*;

public class Backspace {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCases(br);
        }
    }

    private static void handleTestCases(BufferedReader br) throws IOException {
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(isPossible(s, t) ? "YES" : "NO");
    }

    private static boolean isPossible(String s, String t) {
        int N = s.length();
        int M = t.length();
        int pointerS = N - 1;
        int pointerSOld = N;
        int pointerT = M - 1;

        while (pointerS >= 0) {
            if ((s.charAt(pointerS) == t.charAt(pointerT)) && ((pointerS - pointerSOld) % 2 != 0)) {
                pointerT--;
                pointerSOld = pointerS;
            }
            if (pointerT < 0) return true;
            pointerS--;
        }
        return false;
    }
}