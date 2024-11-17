import java.io.*;
import java.util.*;

public class AssemblyViaMinimums {
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
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(n, b);
    }

    private static void evaluate(int n, int[] b) {
        Arrays.sort(b);
        int pointer = 0;
        for (int i = 0; i < n - 1; i++) {
            pointer = pointer + (n - i - 1);
            System.out.print(b[pointer - 1] + " ");
        }
        System.out.println(b[b.length - 1]);
    }
}