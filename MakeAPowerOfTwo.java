import java.io.*;
import java.util.*;

public class MakeAPowerOfTwo {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int ans = makePowOfTwo(N);
            System.out.println(ans);
        }
    }

    private static int makePowOfTwo(int n) {
        int edit = midEdit("1", String.valueOf(n));
        for (int i = 1; i <= 62; i++) {
            long pow = (long) 1 << i;
            String stringPow = String.valueOf(pow);
            String stringVal = String.valueOf(n);
            edit = Math.min(midEdit(stringPow, stringVal), edit);
        }
        return edit;
    }

    private static int midEdit(String stringPow, String stringVal) {
        int N = stringPow.length();
        int M = stringVal.length();
        int pointerPow = 0;
        int pointerVal = 0;
        while (pointerVal < M && pointerPow < N) {
            if (stringPow.charAt(pointerPow) == stringVal.charAt(pointerVal)) {
                pointerPow++;
            }
            pointerVal++;
        }
        int numberOfDelete = M - pointerPow;
        int numberOfAdd = N - pointerPow;
        // System.out.println(stringPow + " " + stringVal + " = " + (numberOfAdd +
        // numberOfDelete));
        return numberOfAdd + numberOfDelete;
    }
}