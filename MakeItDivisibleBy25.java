import java.io.*;
import java.util.*;

public class MakeItDivisibleBy25 {
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
        String input = br.readLine();
        int case1Flag1 = -1;
        int case1Flag2 = -1;
        int case2Flag1 = -1;
        int case2Flag2 = -1;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (case1Flag1 == -1 && input.charAt(i) == '0') {
                case1Flag1 = i;
            } else if (case1Flag2 == -1 && case1Flag1 != -1 && (input.charAt(i) == '0' || input.charAt(i) == '5')) {
                case1Flag2 = i;
            }

            if (case2Flag1 == -1 && input.charAt(i) == '5') {
                case2Flag1 = i;
            } else if (case2Flag2 == -1 && case2Flag1 != -1 && (input.charAt(i) == '2' || input.charAt(i) == '7')) {
                case2Flag2 = i;
            }
        }

        int res = input.length() - Math.max(case1Flag2, case2Flag2) - 2;
        System.out.println(res);
    }
}