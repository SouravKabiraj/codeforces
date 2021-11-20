import java.io.*;
import java.util.*;

public class DominantCharacter {
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
        evaluate(N, input);
    }

    private static void evaluate(int n, String input) {
        for (int len = 2; len <= 4; len++) {
            for (int start = 0; start < n - len + 1; start++) {
                int end = start + len - 1;
                switch (len) {
                    case 2:
                        if (input.charAt(start) == 'a' && input.charAt(end) == 'a') {
                            System.out.println(2);
                            return;
                        }
                        break;
                    case 3:
                        if (input.charAt(start) == 'a' && input.charAt(end) == 'a') {
                            System.out.println(3);
                            return;
                        }
                        break;
                    case 4:
                        if ((input.charAt(start) == 'a' && input.charAt(end) == 'a') && input.charAt(start + 1) != input.charAt(start + 2)) {
                            System.out.println(4);
                            return;
                        }
                        break;
                }
            }
        }

        int len7 = 7;
        for (int start = 0; start < n - len7 + 1; start++) {
            int end = start + len7 - 1;
            boolean b = input.charAt(start) == 'a' && input.charAt(end) == 'a' && input.charAt(start + 3) == 'a';
            boolean k = (input.charAt(start + 1) == input.charAt(start + 2)) && (input.charAt(end - 1) == input.charAt(end - 2)) && (input.charAt(start + 1) != input.charAt(end - 1));
            if (b && k) {
                System.out.println(7);
                return;
            }
        }
        System.out.println(-1);
    }
}