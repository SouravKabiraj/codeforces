import java.io.*;
import java.util.*;

public class AllAreSame {
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
        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, a);
    }

    private static void evaluate(int N, int[] a) throws IOException {
        Set<Integer> diffs = new HashSet<>();
        boolean allSame = true;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, a[i]);
            if (a[i] != a[0]) {
                allSame = false;
            }
        }


        if (allSame) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N; i++) {
            diffs.add(a[i] - min);
        }

        // System.out.println(diffs);

        int gcd = -1;
        for (int e : diffs) {
            if (gcd == -1) {
                gcd = e;
            } else {
                gcd = getGCD(gcd, e);
            }
        }
        System.out.println(gcd);
        return;
    }

    private static int getGCD(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a == b)
            return a;

        if (a > b)
            return getGCD(a - b, b);
        return getGCD(a, b - a);
    }
}