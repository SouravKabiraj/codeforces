import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class DifferentDifferences {
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
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = arr[0];
        int n = arr[1];
        evaluate(k, n);
    }

    private static void evaluate(int k, int n) {
        int[] arr = IntStream.range(0, k).map(i -> (n - k + i) + 1).toArray();
        int ele = 1;
        for (int i = 0; i < k; i++) {
            int minVal = Math.min(arr[i], ele);
            if (i > 0 && arr[i - 1] >= minVal) {
                break;
            }
            arr[i] = minVal;
            ele = arr[i] + i + 1;
        }
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }
}
