import java.io.*;
import java.util.*;

public class GamerHemose {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] nH = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nH[0];
        int H = nH[1];
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        execute(n, a, H);
    }

    private static void execute(int n, int[] a, int H) throws IOException {
        int[] maxs = new int[2];
        for (int i = 0; i < n; i++) {
            if (maxs[1] < a[i]) {
                maxs[1] = a[i];
                if (maxs[1] > maxs[0]) {
                    int temp = maxs[1];
                    maxs[1] = maxs[0];
                    maxs[0] = temp;
                }
            }
        }

        int BOTH = maxs[0] + maxs[1];

        int count = H / BOTH;
        H = H % BOTH;
        if (H == 0) {
            System.out.println(2 * count);
            return;
        } else {
            H = H - maxs[0];
            if (H <= 0) {
                System.out.println(2 * count + 1);
                return;
            } else {
                System.out.println(2 * (count + 1));
                return;
            }
        }
    }
}