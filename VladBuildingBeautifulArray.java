import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VladBuildingBeautifulArray {
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
        evaluate(n, a);
    }

    private static void evaluate(int n, int[] a) {
        int min = 1000000000;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
        }

        for (int i = 0; i < n; i++) {
            if (min % 2 != a[i] % 2) {
                a[i] = a[i] - min;
                if (min % 2 != a[i] % 2) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}