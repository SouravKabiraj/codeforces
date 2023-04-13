import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeItRound {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        System.out.println(evaluate(n, m));
    }

    private static long evaluate(int n, int m) {
        int two = 0;
        int five = 0;
        long N = n;

        while (n % 2 == 0) {
            two++;
            n = n / 2;
        }

        while (n % 5 == 0) {
            five++;
            n = n / 5;
        }

        long k = 1;

        if (two > five) {
            for (; two > five && k * 5 <= m; five++) {
                k = k * 5;
            }
        } else {
            for (; two < five && k * 2 <= m; two++) {
                k = k * 2;
            }
        }

        while (k * 10 <= m) {
            k = k * 10;
        }

        return (m / k) * k * N;
    }
}


