import java.io.*;
import java.util.*;

public class GrandmaCapaKnitsAScarf {
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
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        System.out.println(execute(N, input));
    }

    private static int execute(int n, String txt) {
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (txt.charAt(start) != txt.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        if (start >= end) {
            return 0;
        } else {
            int a = isPalExcept(txt, txt.charAt(start), n);
            // System.out.println(a);
            int b = isPalExcept(txt, txt.charAt(end), n);
            // System.out.println(b);
            if (a == -1 && b == -1) {
                return -1;
            } else if (a == -1) {
                return b;
            } else if (b == -1) {
                return a;
            } else {
                return Math.min(a, b);
            }
        }
    }

    private static int isPalExcept(String txt, char ch, int n) {
        // System.out.print(ch + " ");
        int count = 0;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (txt.charAt(start) != txt.charAt(end) && txt.charAt(start) == ch) {
                count++;
                start++;
                continue;
            } else if (txt.charAt(start) != txt.charAt(end) && txt.charAt(end) == ch) {
                count++;
                end--;
                continue;
            } else if (txt.charAt(start) != txt.charAt(end)) {
                return -1;
            }
            start++;
            end--;
        }
        return count;
    }
}