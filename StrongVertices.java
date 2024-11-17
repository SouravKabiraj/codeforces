import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StrongVertices {
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
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluation(n, a, b);
    }

    private static void evaluation(int n, int[] a, int[] b) {
        int[] diff = new int[n];
        int MAX = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = a[i] - b[i];
            if (diff[i] > MAX) {
                MAX = diff[i];
                count = 1;
            } else if (diff[i] == MAX) {
                count++;
            }
        }
        System.out.println(count);
        for (int i = 0; i < n; i++) {
            if (MAX == diff[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}