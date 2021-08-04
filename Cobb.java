import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cobb {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = NK[0];
            int K = NK[1];
            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getResult(N, K, A));
        }
    }

    private static long getResult(int n, int k, int[] a) {
        long ans = Long.MIN_VALUE;
        for (int i = Math.max(0, n - 201); i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int I = i + 1;
                int J = j + 1;
                ans = Math.max(ans, (long) I * J - k * (long) (a[i] | a[j]));
            }
        }
        return ans;
    }
}