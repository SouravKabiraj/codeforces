import java.io.*;
import java.util.*;

public class SpecialNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        long MOD = 1000000007;
        long[] nk = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long n = nk[0];
        long k = nk[1];
        long result = 0;
        for (int i = 0; i <= 30; i++) {
            long isSetBit = (1 << i) & k;
            if (isSetBit > 0) {
                result = (result + mathPow(n, i, MOD)) % MOD;
            }
        }
        System.out.println(result);
    }

    private static long mathPow(long ele, long pow, long MOD) {
        // System.out.println(ele + " ^ " + pow);
        if (pow == 0) return 1;
        else if (pow == 1) return ele % MOD;
        long res = 1;
        while (pow > 0) {
            res = (res * ele) % MOD;
            pow--;
        }
        // System.out.println(ele + " ^ " + pow + " %" + MOD + " = " + res);
        return res;
    }
}