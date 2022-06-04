import java.io.*;
import java.util.*;

public class MakeAP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        multiTest(br);
    }

    private static void multiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            test(br);
        }
    }

    private static void test(BufferedReader br) throws IOException {
        int[] abc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = abc[0];
        int b = abc[1];
        int c = abc[2];
        if (option1(a, b, c)) {
            System.out.println("YES");
            return;
        }

        if (option2(a, b, c)) {
            System.out.println("YES");
            return;
        }

        if (option3(a, b, c)) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }

    private static boolean option3(int a, int b, int c) {
        // System.out.println("OP3");
        int diff = b - a;
        int expC = b + diff;
        // System.out.println("EXP:" + expC);
        return (expC % c == 0 && expC >= c);
    }

    private static boolean option2(int a, int b, int c) {
        // System.out.println("OP2");
        if ((c - a) % 2 != 0) return false;
        int diff = (c - a) / 2;
        int expB = a + diff;
        // System.out.println("EXP:" + expB);
        return (expB % b == 0 && expB >= b);
    }

    private static boolean option1(int a, int b, int c) {
        // System.out.println("OP1");
        int diff = c - b;
        int expA = b - diff;
        // System.out.println("EXP:" + expA);
        return (expA % a == 0 && expA >= a);
    }
}