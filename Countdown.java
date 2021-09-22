import java.io.*;
import java.util.*;

public class Countdown {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        br.readLine();
        String str = br.readLine();
        long N = reduceToZero(str);
        System.out.println(N);
    }

    private static long reduceToZero(String str) {
        int N = str.length();
        long res = str.charAt(N - 1) - '0';
        for (int i = N - 2; i >= 0; i--) {
            res = res + (str.charAt(i) != '0' ? (long) (str.charAt(i) - '0') + 1 : 0);
        }
        return res;
    }
}