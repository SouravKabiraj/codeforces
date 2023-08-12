import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SkiResort {
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
        int[] nkq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nkq[0];
        int k = nkq[1];
        int q = nkq[2];
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(n, k, q, a);
    }

    private static void evaluate(int n, int k, int q, int[] a) {
        int start = 0;
        int end = 0;
        long total = 0;
        while (end < n) {
            while (start < n && a[start] > q) {
                start++;
                end++;
            }
            if (start >= n) {
                break;
            }
            while (end < n && a[end] <= q) {
                end++;
            }
            int length = end - start;

            if (length >= k) {
                int p = length - k + 1;
                total = total + ((long) p * (p + 1)) / 2;
            }
            start = end;
        }
        System.out.println(total);
    }
}

/*
E(n-p+1)

1 2 3 4 5 6 7 8 9 10
 */