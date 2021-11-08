import java.io.*;
import java.util.*;

public class VupsenPupsenAnd0 {
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
        System.out.println();
    }

    private static void evaluate(int n, int[] a) {
        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    System.out.print(a[i + 1] + " ");
                } else {
                    System.out.print((-1 * a[i - 1]) + " ");
                }
            }
        } else {
            evaluate(n - 3, a);
            if (a[n - 3] + a[n - 2] + a[n - 1] == 0) {
                System.out.print("1 1 1");
            } else if (a[n - 3] + a[n - 2] != 0) {
                System.out.print(a[n - 1] + " " + a[n - 1] + " " + (-1) * (a[n - 3] + a[n - 2]));
            } else if (a[n - 2] + a[n - 1] != 0) {
                System.out.print((-1) * (a[n - 1] + a[n - 2]) + " " + a[n - 3] + " " + a[n - 3]);
            } else {
                System.out.print(a[n - 2] + " " + (-1) * (a[n - 1] + a[n - 3]) + " " + a[n - 2]);
            }
        }
    }
}
