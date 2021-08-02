import java.io.*;

public class Diane {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            printString(N);
        }
    }

    private static void printString(int n) {
        String ans = "";
        if (n == 1) {
            ans = "a";
        } else if (n % 2 == 0) {
            ans = "a".repeat(n / 2) + "b" + "a".repeat((n / 2) - 1);
        } else {
            ans = "a".repeat(n / 2) + "b" + "a".repeat((n / 2) - 1) + "c";
        }
        System.out.println(ans);
    }
}