import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;

public class InsertDigit {
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
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        String number = br.readLine();
        evaluate(n, number, k);
    }

    private static void evaluate(int n, String number, int k) {
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (k > (number.charAt(i) - '0') && flag) {
                flag = false;
                System.out.print(k);
            }
            System.out.print(number.charAt(i));
        }
        if (flag) {
            System.out.print(k);
        }
        System.out.println();
    }
}