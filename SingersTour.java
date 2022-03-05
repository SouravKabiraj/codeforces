import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

public class SingersTour {
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
        int n = Integer.parseInt(br.readLine());
        long[] b = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        evaluate(n, b);
    }

    private static void evaluate(int n, long[] b) {
        long[] a = new long[n];
        long nF = (long) (n + 1) * (long) n / 2;
        AtomicLong Sb = new AtomicLong();
        Arrays.stream(b).forEach(Sb::addAndGet);
        if (Sb.get() % nF != 0) {
            System.out.println("NO");
            return;
        }
        long Sa = Sb.get() / nF;
        for (int i = 0; i < n; i++) {
            long k = b[i] - b[i - 1 == -1 ? n - 1 : i - 1];
            k = Sa - k;
            if (k <= 0 || (k % n) != 0) {
                System.out.println("NO");
                return;
            }
            a[i] = k / n;
        }
        System.out.println("YES");
        Arrays.stream(a).mapToObj(String::valueOf).map(e -> e + " ").forEach(System.out::print);
        System.out.println();
    }
}