import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayDecrements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTestCase(br);
    }

    private static void handleMultiTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, a, b);
    }

    private static void evaluate(int n, int[] a, int[] b) {
        int minD = 0;
        for (int i = 0; i < n; i++) {
            int diff = a[i] - b[i];
            minD = Math.max(diff, minD);
        }
        for (int i = 0; i < n; i++) {
            int diff = a[i] - b[i];
            if (b[i] == 0 && diff > minD) {
                System.out.println("NO");
                return;
            } else if (b[i] != 0 && diff != minD) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

