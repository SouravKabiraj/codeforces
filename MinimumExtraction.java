import java.io.*;
import java.util.*;

public class MinimumExtraction {
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
        int n = Integer.parseInt(br.readLine());
        long[] a = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        evaluate(n, a);
    }

    private static void evaluate(int n, long[] a) {
        Arrays.sort(a);
        long diff = 0;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = a[i] - diff;
            max = Math.max(max, a[i]);
            diff = diff + a[i];
        }
        System.out.println(max);
    }
}
