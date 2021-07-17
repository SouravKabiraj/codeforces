import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrettyPermutations {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String result = "";
        if (N % 2 == 0) {
            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0)
                    result = result + (i - 1) + " ";
                else
                    result = result + (i + 1) + " ";
            }
        } else {
            result = "3 1 2 ";
            for (int i = 4; i <= N; i++) {
                if (i % 2 == 1)
                    result = result + (i - 1) + " ";
                else
                    result = result + (i + 1) + " ";
            }
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}
