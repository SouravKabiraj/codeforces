import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;

public class PolycarpAndTheDayOfPi {

    private static final int[] PI = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3, 8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        executeMultiTest(br);
    }

    private static void executeMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            executeTest(br);
        }
    }

    private static void executeTest(BufferedReader br) throws IOException {
        int[] A = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != PI[i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(A.length);
    }
}