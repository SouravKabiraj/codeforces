import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayAndOperations {
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
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        evaluate(n, k, a);
    }

    private static void evaluate(int n, int k, int[] a) {
        int p1 = n - 1;
        int p2 = p1 - k;
        int p3 = n - 2 * k;
        int result = 0;
        for (int i = 0; i < p3; i++) {
            result = result + a[i];
        }

        while (p2 >= p3) {
            result = result + a[p2] / a[p1];
            p2--;
            p1--;
        }
        System.out.println(result);
    }
}