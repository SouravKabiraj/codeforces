import java.io.*;
import java.util.*;

public class RubiksCubeColoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long MOD = 1000000007;
        long pm = Pow(2, (long) N) - 2;
        long waysAfterSecondLevel = powMod(4, pm, MOD);
        System.out.println((waysAfterSecondLevel * 6) % MOD);
    }

    private static long powMod(long base, long pow, long mod) {
        if (pow == 0) return 1;
        else {
            long res = 1;

            while (pow > 1) {
                if (pow % 2 == 1) {
                    res = (res * base) % mod;
                }
                pow = pow / 2;
                base = (base * base) % mod;
            }
            res = (res * base) % mod;
            return res;
        }
    }

    private static long Pow(long base, long pow) {
        if (pow == 0) return 1;
        else {
            long res = 1;

            while (pow > 1) {
                if (pow % 2 == 1) {
                    res = (res * base);
                }
                pow = pow / 2;
                base = (base * base);
            }
            res = (res * base);
            return res;
        }
    }
}