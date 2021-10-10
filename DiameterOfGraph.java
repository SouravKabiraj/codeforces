import java.io.*;
import java.util.*;

public class DiameterOfGraph {
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
        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0];
        int m = nmk[1];
        int k = nmk[2] - 2;

        int t = (n * (n - 1)) / 2;

        if (m < n - 1 || t < m) {
            System.out.println("NO");
            return;
        }

        if (k == 0 && n == 1) {
            System.out.println("YES");
            return;
        }

        if (k >= 2) {
            System.out.println("YES");
            return;
        }

        if (k == 1 && m == t) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
        return;
    }
}