import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Flipper {
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
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(n, arr);
    }

    private static void evaluate(int n, int[] arr) {
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        int findFirstNumber = n == arr[0] ? n - 1 : n;
        int R = -1;
        for (int i = 1; i < n; i++) {
            if (findFirstNumber == arr[i]) {
                R = i;
            }
            if (R != -1) {
                System.out.print(arr[i] + " ");
            }
        }
        if (R == n - 1 && arr[R - 1] < arr[0]) {
            for (int i = 0; i < R; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        System.out.print(arr[R - 1] + " ");
        int L = R - 2;

        while (0 < L) {
            if (arr[L] < arr[0]) {
                break;
            }
            System.out.print(arr[L] + " ");
            L--;
        }
        for (int i = 0; i <= L; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}