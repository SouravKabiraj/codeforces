import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MusicalPuzzle {
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
        String str = br.readLine();
        evaluate(n, str);
    }

    private static void evaluate(int n, String str) {
        boolean[][] noteComb = new boolean[7][7];
        for (int i = 0; i < n - 1; i++) {
            int ch1 = str.charAt(i) - 'a';
            int ch2 = str.charAt(i + 1) - 'a';
            noteComb[ch1][ch2] = true;
        }
        int result = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (noteComb[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}