import java.io.*;

public class DigitsSum {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            System.out.println(getDigitSum(Integer.parseInt(br.readLine())));
        }
    }

    private static int getDigitSum(int N) {
        int res = N / 10;
        if (N % 10 == 9) {
            res++;
        }
        return res;
    }
}