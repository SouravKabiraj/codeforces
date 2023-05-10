import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;

public class VladAndAPairOfNumbers {
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
        int xor = Integer.parseInt(br.readLine());
        evaluate(xor);
    }

    private static void evaluate(int xor) {
        if (xor % 2 != 0) {
            System.out.println(-1);
            return;
        }
        int and = xor / 2;
        int a = xor + and;
        int b = and;
        if ((a ^ b) == xor) {
            System.out.println(a + " " + b);
        } else {
            System.out.println(-1);
        }
        return;
    }
}