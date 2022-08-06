import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RestoringTheDurationOfTasks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++)
            handleTest(br);
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] f = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, s, f);
    }

    private static void evaluate(int n, int[] s, int[] f) {
        int prevEnd = 0;
        for (int i = 0; i < n; i++) {
            prevEnd = Math.max(prevEnd, s[i]);
            int d = f[i] - prevEnd;
            if (i == n - 1) System.out.println(d);
            else System.out.print(d + " ");
            prevEnd = Math.max(prevEnd, f[i]);
        }
    }
}