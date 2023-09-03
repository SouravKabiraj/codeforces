import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongLong {
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
        int result = 0;
        long totalCost = 0;

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (a[i] < 0 && !flag) {
                result++;
                flag = true;
            }
            if (a[i] > 0 && flag) {
                flag = false;
            }
            totalCost = totalCost + Math.abs((long) a[i]);
        }

        System.out.println(totalCost + " " + result);
    }
}