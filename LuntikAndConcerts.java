import java.io.*;
import java.util.*;

public class LuntikAndConcerts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int extra = 0;
        if (a[2] % 2 == 1) {
            extra = extra + 3;
        }

        while (extra - 2 >= 0 && a[1] > 0) {
            a[1]--;
            extra = extra - 2;
        }

        if (a[1] % 2 == 1) {
            extra = (int) Math.abs(extra - 2);
        }

        while (extra - 2 >= 0 && a[1] > 0) {
            a[1]--;
            extra = extra - 2;
        }

        if (a[0] % 2 == 1) {
            extra = (int) Math.abs(extra - 1);
        }

        System.out.println(extra);
    }
}