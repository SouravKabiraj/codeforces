import java.io.*;
import java.util.*;
import java.util.stream.*;

public class KorneyKorneevichAndXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTest(br);
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, a);
    }

    private static void evaluate(int n, int[] a) {
        TreeSet<Integer> res = new TreeSet<>();
        res.add(0);
        int[] dp = new int[520];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 513; j++) {
                if (dp[j] < a[i]) {
                    dp[(j ^ a[i])] = Math.min(dp[(j ^ a[i])], a[i]);
                }
            }
        }
        for (int i = 1; i < 515; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                res.add(i);
            }
        }
        System.out.println(res.size());
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}