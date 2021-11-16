import java.io.*;
import java.util.*;

public class Era {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
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

    private static void evaluate(int N, int[] a) {
        int count = a[0] - 1;
        for (int i = 1; i < N; i++) {
            if (a[i] <= a[i - 1]) {
                a[i] = a[i - 1] + 1;
            }
        }
        for (int i = 1; i < N; i++) {
            count = count + (a[i] - a[i - 1] - 1);
        }
        System.out.println(count);
    }
}