import java.io.*;
import java.util.Arrays;

public class Pursuit {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int result = getNumberOfStage(N, a, b);
        System.out.println(result);
    }

    private static int getNumberOfStage(int n, int[] a, int[] b) {
        int k = n - (n / 4);
        int me = 0;
        int you = 0;
        for (int i = n - 1; i >= n - k; i--) {
            me = me + a[i];
            you = you + b[i];
        }
        k = (n / 4);
        if (me >= you) return 0;
        int x = k;
        int y = k - 1;
        int r = n;
        int ans = 0;
        int zero = 0;
        while (true) {
            if (me >= you) break;
            me = me + 100;
            zero++;
            if (y >= 0) {
                you = you + b[y];
                y--;
            }
            r++;
            if (r / 4 > k) {
                k++;
                me = me - a[x];
                x++;
                if (zero < k) {
                    you = you - b[y + 1];
                    y++;
                }
            }
            ans++;
        }
        return ans;
    }
}
