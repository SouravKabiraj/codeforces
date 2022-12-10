import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PriceMaximization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++)
            handleTest(br);
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, K, a);
    }

    private static void evaluate(int n, int k, int[] a) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (a[i] / k);
            a[i] = a[i] % k;
        }
        Arrays.sort(a);
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            if (a[start] + a[end] >= k) {
                start++;
                end--;
                sum++;
            } else {
                start++;
            }
        }
        System.out.println(sum);
    }
}

