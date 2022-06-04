import java.io.*;
import java.util.*;

public class PlusOneOnTheSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            hendleTest(br);
        }
    }

    private static void hendleTest(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        execute(n, a);
    }

    private static void execute(int n, int[] a) {
        int max = 0;
        int min = 1000000001;
        for (int i = 0; i < n; i++) {
            min = Math.min(a[i], min);
            max = Math.max(a[i], max);
        }
        System.out.println(max - min);
    }
}
