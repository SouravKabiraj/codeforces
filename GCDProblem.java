import java.io.*;

public class GCDProblem {
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
        evaluate(n);
    }

    private static void evaluate(int n) {
        if (n % 2 == 0) {
            System.out.println("2 " + (n - 3) + " 1");
        } else {
            n = n - 1;
            if ((n / 2) % 2 == 0) {
                System.out.println((n / 2 + 1) + " " + (n / 2 - 1) + " 1");
            } else {
                System.out.println((n / 2 + 2) + " " + (n / 2 - 2) + " 1");
            }
        }
    }
}