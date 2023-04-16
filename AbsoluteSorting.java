import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;

public class AbsoluteSorting {
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
        int lowLim = 0;
        int highLim = 0;
        for (int i = 0; i < n; i++) {
            highLim = Math.max(arr[i], highLim);
            if (i > 0 && arr[i - 1] > arr[i]) {
                int newLow = 0;
                if ((arr[i] + arr[i - 1]) % 2 == 0) {
                    newLow = (arr[i] + arr[i - 1]) / 2;
                } else {
                    newLow = (arr[i] + arr[i - 1] + 1) / 2;
                }
                lowLim = Math.max(lowLim, newLow);
            }
        }
        if (lowLim <= highLim && isValid(n, arr, lowLim)) {
            System.out.println(lowLim);
            return;
        }
        System.out.println(-1);
    }

    private static boolean isValid(int n, int[] arr, int lowLim) {
        int[] alt = new int[n];
        for (int i = 0; i < n; i++) {
            alt[i] = Math.abs(arr[i] - lowLim);
            if (i > 0 && alt[i - 1] > alt[i]) {
                return false;
            }
        }
        return true;
    }
}



/*
10 5 4 3 2 1
2 3 8 5 6 7
 */