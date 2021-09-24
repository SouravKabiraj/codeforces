import java.io.*;
import java.util.*;

public class CombinatoricsHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] ABCD = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = ABCD[0];
        int B = ABCD[1];
        int C = ABCD[2];
        int D = ABCD[3];
        execute(A, B, C, D);
    }


    private static void execute(int a, int b, int c, int m) {
        boolean flag = true;
        int aM = a - 1;
        int bM = b - 1;
        int cM = c - 1;

        if (aM + bM + cM < m) {
            flag = false;
            System.out.println("NO");
            return;
        }

        int total = a + b + c;
        int max = Math.max(Math.max(a, b), c);
        int rest = total - max;
        if (max - rest - 1 > m) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}