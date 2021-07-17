import java.io.*;
import java.util.Arrays;

public class PleasantPairs {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestcases(br);
    }

    private static void handleMultipleTestcases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestcase(br);
        }
    }

    private static void handleTestcase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p = getNumberOfPairs(N, arr);
        System.out.println(p);
    }

    private static int getNumberOfPairs(int n, int[] arr) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = arr[i - 1] - i; j <= n; j = j + arr[i - 1]) {
                if (j > 0 && i < j && (arr[i - 1] * arr[j - 1]) == i + j) {
                    count++;
                }
            }
        }
        return count;
    }
}