import java.io.*;

public class Penalty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        String input = br.readLine();
        int ans = getMinKick(input);
        System.out.println(ans);
    }

    private static int getMinKick(String input) {
        int N = input.length();

        int diff1 = 0;
        int diff2 = 0;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                diff1 = diff1 + (input.charAt(i) != '0' ? 1 : 0);
                diff2 = diff2 + (input.charAt(i) != '1' ? 0 : -1);
            } else {
                diff1 = diff1 + (input.charAt(i) != '1' ? 0 : -1);
                diff2 = diff2 + (input.charAt(i) != '0' ? 1 : 0);
            }
            if (diff1 > ((N - i) / 2) || diff2 > ((N - i - 1) / 2)) {
                return i + 1;
            }
        }

        return N;
    }
}