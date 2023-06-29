import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunLover {
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
        long result = 1 + (long) (n) * (n - 1) / 2 + (long) (n - 1) * (n - 2) / 2 + n * 4L;
        System.out.println(result);
    }
}
