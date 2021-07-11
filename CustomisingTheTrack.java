import java.io.*;
import java.util.Arrays;

public class CustomisingTheTrack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleSingleTestCase(br);
        }
    }

    private static void handleSingleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + arr[i];
        }
        long avg = sum / N;
        long extra = sum - avg * N;
        System.out.println(extra * (N - extra));
    }
}