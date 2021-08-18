import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MochaAndMath {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleCase(br);
    }

    private static void handleMultipleCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleSingleCase(br);
        }
    }

    private static void handleSingleCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getMinAnd(N, A));
    }

    private static int getMinAnd(int n, int[] a) {
        int res = a[0];
        for (int i = 1; i < n; i++) {
            res = res & a[i];
        }
        return res;
    }
}