import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SashaAndArrayColoring {
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
        Arrays.sort(a);
        int start = 0;
        int end = n - 1;
        while (start < end) {
            result = result + Math.abs(a[start] - a[end]);
            start++;
            end--;
        }
        System.out.println(result);
    }
}