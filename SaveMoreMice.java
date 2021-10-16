import java.io.*;
import java.util.*;

public class SaveMoreMice {
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
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        Arrays.sort(a);
        evaluate(n, a);
    }

    private static void evaluate(int n, int[] a) {
        int cat = 0;
        int catchIndex = -1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (cat < a[i]) {
                cat = cat + (n - a[i]);
            } else {
                catchIndex = i;
                break;
            }
        }

        System.out.println(a.length - (catchIndex + 1));
    }
}