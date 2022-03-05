import java.io.*;
import java.util.*;

public class WrongAddition {
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
        String[] as = br.readLine().split(" ");
        evaluate(as[0], as[1]);
    }

    private static void evaluate(String a, String s) {
        int i = a.length() - 1;
        int j = s.length() - 1;
        StringBuilder b = new StringBuilder();
        while (j >= 0) {
            // System.out.println("a:" + a.charAt(i));
            if (i < 0) {
                b.insert(0, s.charAt(j));
                j--;
            } else if (a.charAt(i) > s.charAt(j) && j > 0 && s.charAt(j - 1) == '1') {
                int newS = 10 + (s.charAt(j) - '0');
                // System.out.println("s:" + newS);
                int ex = newS - Integer.parseInt(String.valueOf(a.charAt(i)));
                // System.out.println(ex);
                b.insert(0, ex);
                i--;
                j = j - 2;
            } else if (a.charAt(i) <= s.charAt(j)) {
                // System.out.println("s:" + s.charAt(j));
                char ex = (char) (s.charAt(j) - a.charAt(i) + '0');
                // System.out.println(ex);
                b.insert(0, ex);
                i--;
                j--;
            } else {
                System.out.println(-1);
                return;
            }

        }
        if (i >= 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(Long.parseLong(String.valueOf(b)));
    }
}