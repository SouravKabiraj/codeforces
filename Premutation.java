import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Premutation {
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
        int N = Integer.parseInt(br.readLine());
        int[][] AR = new int[N][N - 1];
        for (int i = 0; i < N; i++) {
            AR[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        evaluate(N, AR);
    }

    private static void evaluate(int n, int[][] ar) {
        int first_index = 0;
        for (int i = 0; i < n - 2; i++) {
            if (ar[i][0] != ar[i + 1][0] || ar[i + 2][0] != ar[i + 1][0]) {
                if (ar[i][0] == ar[i + 1][0]) {
                    first_index = i + 2;
                } else if (ar[i + 2][0] == ar[i + 1][0]) {
                    first_index = i;
                } else {
                    first_index = i + 1;
                }
            }
        }
        if (first_index == 0) {
            System.out.print(ar[1][0] + " ");
        } else {
            System.out.print(ar[first_index - 1][0] + " ");
        }
        Arrays.stream(ar[first_index]).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }
}