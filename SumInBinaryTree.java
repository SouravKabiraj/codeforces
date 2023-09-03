import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumInBinaryTree {
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
        long n = Long.parseLong(br.readLine());
        System.out.println(evaluate(n));
    }

    private static long evaluate(long n) {
        if (n == 1) return 1L;
        return n + evaluate(n / 2);
    }
}