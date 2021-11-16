import java.io.*;
import java.util.*;

public class XORSpeciaLISt {
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
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (n % 2 == 0) {
            System.out.println("YES");
            return;
        }

        for (int i = 1; i < n; i++) {
            if (a[i] <= a[i - 1]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
        return;
    }
}
