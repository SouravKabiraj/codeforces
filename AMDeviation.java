import java.io.*;
import java.util.*;

public class AMDeviation {
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
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = a[0] + a[2];
        int d = 2 * a[1];
        if (sum == d) {
            System.out.println(0);
            return;
        }
        if (Math.abs(sum - d) % 3 == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}