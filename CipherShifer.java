import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CipherShifer {
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
        char currChar = '*';
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (currChar == '*') {
                currChar = str.charAt(i);
                resultBuilder.append(str.charAt(i));
            } else if (currChar == str.charAt(i)) {
                currChar = '*';
            }
        }
        System.out.println(resultBuilder);
    }
}