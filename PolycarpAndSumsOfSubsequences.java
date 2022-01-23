import java.io.*;
import java.util.Arrays;

public class PolycarpAndSumsOfSubsequences {
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
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(b);
    }

    private static void evaluate(int[] b) {
        int[] a = new int[3];
        a[0] = b[0];
        a[1] = b[4] - b[0];
        a[2] = b[6] - a[0] - a[1];
        System.out.println(a[0] + " " + a[1] + " " + a[2]);
    }
}
