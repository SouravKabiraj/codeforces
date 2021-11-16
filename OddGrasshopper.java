import java.io.*;
import java.util.*;

public class OddGrasshopper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++)
            handleTest(br);
    }

    private static void handleTest(BufferedReader br) throws IOException {
        long[] x0N = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long x0 = x0N[0];
        long n = x0N[1];
        if (x0 % 2 == 0) {
            long M = n / 4;
            long N = n % 4;

            if (N == 0) {
                System.out.println(x0);
                return;
            }
            if (N == 1) {
                System.out.println(x0 - 1 - (4 * M));
                return;
            }
            if (N == 2) {
                System.out.println(x0 + 1);
                return;
            }
            if (N == 3) {
                System.out.println(x0 + 4 * (M + 1));
                return;
            }

        } else {
            long M = n / 4;
            long N = n % 4;
            if (N == 0) {
                System.out.println(x0);
                return;
            }
            if (N == 1) {
                System.out.println(x0 + 1 + (4 * M));
                return;
            }
            if (N == 2) {
                System.out.println(x0 - 1);
                return;
            }
            if (N == 3) {
                System.out.println(x0 - 4 * (M + 1));
                return;
            }
        }
    }
}