import java.io.*;
import java.util.*;

public class MEXorMixup {

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMUltipleTestCases(br);
    }

    private static void handleMUltipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCases(br);
        }
    }

    private static void handleTestCases(BufferedReader br) throws IOException {
        int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = ab[0];
        int b = ab[1];
        int N = getArrayLength(a, b);
        System.out.println(N);
    }

    private static int getArrayLength(int a, int b) {
        if (a == b && a == 1) return 3;
        int totalXOR = getXORFor(a);
        int ans = totalXOR ^ b;
        if (totalXOR == b) {
            return a;
        } else if (ans == a) {
            return a + 2;
        } else {
            return a + 1;
        }
    }

    private static int getXORFor(int a) {
        a--;
        if (a % 4 == 0) return a;
        if (a % 4 == 1) return 1;
        if (a % 4 == 2) return a + 1;
        return 0;
    }
}