import java.io.*;
import java.text.*;
import java.util.*;

public class EzzatAndTwoSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double res = findF(N, A);
        DecimalFormat df = new DecimalFormat("#.#########");
        System.out.println(df.format(res));
    }

    private static double findF(int n, int[] a) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            max = Math.max(max, a[i]);
        }
        sum = sum - max;
        double fa = (double) sum / (n - 1);
        double fb = max;
        return fa + fb;
    }
}