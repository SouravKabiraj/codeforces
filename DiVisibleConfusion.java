import java.io.*;
import java.util.*;

public class DiVisibleConfusion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTask(br);
    }

    private static void handleMultiTask(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTask(br);
        }
    }

    private static void handleTask(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(n, a);
    }

    private static void evaluate(int n, int[] a) {
        for (int i = 0; i < n; i++) {
            int I = i + 2;
            int j = I;
            for (; j >= 2; j--) {
                if (a[i] % j != 0) {
                    break;
                }
            }
            if (j == 1) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
