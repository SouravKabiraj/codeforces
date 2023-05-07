import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaisiaAndDice {
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
        int[] nsr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nsr[0];
        int s = nsr[1];
        int r = nsr[2];
        evaluate(n, s, r);
    }

    private static void evaluate(int n, int s, int r) {
        int N = n - 1;
        int missing = s - r;
        for (int i = 0; i < N; i++) {
            int avg = (r / (N - i)) + ((r % (N - i)) == 0 ? 0 : 1);
            if (r < avg) {
                System.out.print(r + ". ");
            } else {
                System.out.print(avg + " ");
            }
            r = r - avg;
        }
        System.out.println(missing);
    }
}