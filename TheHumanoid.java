import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheHumanoid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] nh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nh[0];
        int h = nh[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        System.out.println(evaluate(n, 0, h, arr, 1, 2));
    }

    private static int evaluate(int n, int startIndex, long h, int[] arr, int b, int g) {
        if (startIndex == n) {
            return 0;
        }
        if (arr[startIndex] < h) {
            long inc = arr[startIndex] / 2;
            return evaluate(n, startIndex + 1, h + inc, arr, b, g) + 1;
        }
        int sol1 = b >= 1 ? evaluate(n, startIndex, h * 3, arr, b - 1, g) : 0;
        int sol2 = g >= 1 ? evaluate(n, startIndex, h * 2, arr, b, g - 1) : 0;
        return Math.max(sol1, sol2);
    }
}


/*
4 1
  * 1 1 2 15
    0 0 1 7

15 = ((1 * 2^x * 3 ^ y)* 2^(2-x) * 3 ^ (1-y))
 */