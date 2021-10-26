import java.io.*;
import java.util.*;

public class LuntikAndSubsequences {
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
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(execute(N, a));
    }

    private static long execute(int n, int[] a) {
        long zeros = 0;
        long ones = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) zeros++;
            if (a[i] == 1) ones++;
        }

        return ones * (long) Math.pow(2, zeros);
    }
}