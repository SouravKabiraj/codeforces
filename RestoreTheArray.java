import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RestoreTheArray {
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
        int[] a = new int[n];
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        a[0] = b[0];
        for (int i = 0; i < n - 1; i++) {
            // System.out.println(">>" + b[i]);
            if (b[i] < a[i]) {
                a[i] = b[i];
            }
            a[i + 1] = b[i];
        }
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
