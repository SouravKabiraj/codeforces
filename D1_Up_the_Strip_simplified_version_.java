import java.io.*;
import java.util.*;

public class D1_Up_the_Strip_simplified_version_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTestCase(br);
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inp[0];
        int MOD = inp[1];
        int res = getNumberOfWay(N, MOD);
        System.out.println(res);
    }

    private static int getNumberOfWay(int N, int MOD) {
        long[] DP = new long[N + 1];
        DP[1] = 1;
        long oldDP = 1;
        for (int x = 2; x <= N; x++) {
            for (int i = 1; i <= (x / 2); i++) {
                int count = (x / i) - (x / (i + 1));
                DP[x] = DP[x] + (((long) count % MOD) * ((long) DP[i] % MOD) % MOD);
            }
            DP[x] = (((long) DP[x] % MOD + (long) oldDP % MOD) % MOD);
            oldDP = (oldDP % MOD + DP[x] % MOD) % MOD;
        }
        return (int) DP[N];
    }
}