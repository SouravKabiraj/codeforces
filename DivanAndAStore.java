import java.io.*;
import java.util.*;

public class DivanAndAStore {
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
        int[] nlrk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nlrk[0];
        int l = nlrk[1];
        int r = nlrk[2];
        int k = nlrk[3];
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        evaluate(n, l, r, k, a);
    }

    private static void evaluate(int n, int l, int r, int k, int[] a) {
        int count = 0;
        for (int i = 0; i < n && k > 0 && a[i] <= k && a[i] <= r; i++) {
            if (a[i] < l) {
                continue;
            }
            count++;
            k = k - a[i];
        }
        System.out.println(count);
    }
}
