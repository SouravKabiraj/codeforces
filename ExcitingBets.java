import java.io.*;
import java.util.*;

public class ExcitingBets {
    public static void main(String[] str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTestcase(br);
    }

    private static void handleMultiTestcase(BufferedReader br) throws IOException {
        long T = Long.parseLong(br.readLine());
        for (long i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        long[] inputs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long a = Math.max(inputs[0], inputs[1]);
        long b = Math.min(inputs[0], inputs[1]);
        long m = a - b;

        if (m == 0) {
            System.out.println(0 + " " + 0);
        } else {
            long A = a;
            long B = b;
            long ops = Long.MAX_VALUE;
            a = (A / m) * m;
            b = (B / m) * m;

            while (true) {
                if (a % m == 0 && b % m == 0) {
                    ops = A - a;
                    break;
                }
                a = a - m;
                b = b - m;
            }

            a = (A / m + 1) * m;
            b = (B / m + 1) * m;

            while (true) {
                if (a % m == 0 && b % m == 0) {
                    ops = Math.min(ops, Math.abs(A - a));
                    break;
                }
                a = a + m;
                b = b + m;
            }
            System.out.println(m + " " + ops);
        }
    }
}