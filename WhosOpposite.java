import java.io.*;
import java.util.*;

public class WhosOpposite {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] abc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = abc[0];
        int b = abc[1];
        int c = abc[2];
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println(getResult(a, b, c));
    }

    private static int getResult(int a, int b, int c) {
        int total = (b - a - 1) * 2 + 2;
        if (c > total || total < b || total < a) {
            return -1;
        }
        int res = a + (c - b);
        if (c > b) {
            res = a + (c - b);
        } else if (a < c && c < b) {
            res = b + (c - a);
        } else {
            res = b - (a - c);
        }
        if (res > total) {
            res = res - total;
        }
        // System.out.println(res);
        if (res > total || res == a || res == b || res == c)
            return -1;
        return res;
    }
}