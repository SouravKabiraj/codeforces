import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) handleSingleTestCase(br);
    }

    private static void handleSingleTestCase(BufferedReader br) throws IOException {
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        boolean ans = getResult(arr);
        System.out.println(ans ? "Yes" : "No");
    }

    private static boolean getResult(int[] arr) {
        int odd = 0;
        int even = 0;
        for (int j : arr) {
            if (j % 2 == 1) {
                odd++;
            } else {
                even++;
            }
        }
        return odd == even;
    }
}
