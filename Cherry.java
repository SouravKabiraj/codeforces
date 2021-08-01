import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cherry {
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
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long ans = getPord(N, A);
        System.out.println(ans);
    }

    private static long getPord(int n, int[] a) {
        long max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max((long) a[i] * (long) a[i + 1], max);
        }
        return max;
    }
}

/*

2 4 3
3 2 3 1
69 69
719313 273225 402638 473783 804745 323328




12
6
4761
381274500335

 */