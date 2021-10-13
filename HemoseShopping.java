import java.io.*;
import java.util.*;

public class HemoseShopping {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
        int[] nx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nx[0];
        int x = nx[1];
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = new int[n];
        boolean isSorted = true;
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
            if (i > 0 && a[i - 1] > a[i]) {
                isSorted = false;
            }
        }
        if (isSorted) {
            System.out.println("YES");
            return;
        }
        if (x >= n) {
            System.out.println("NO");
            return;
        }
        if (x * 2 <= n) {
            System.out.println("YES");
            return;
        }
        Arrays.sort(a);

        for (int i = n - x; i < x; i++) {
            // System.out.print(b[i] + " ");
            if (b[i] != a[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}