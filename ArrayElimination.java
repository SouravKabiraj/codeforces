import java.io.*;
import java.util.*;

public class ArrayElimination {
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
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, A);
    }

    private static void evaluate(int n, int[] arr) {
        int[] bitCount = new int[31];
        int totalBit = 0;
        for (int i = 0; i <= 30; i++) {
            int num = 1 << i;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & num) != 0) {
                    bitCount[i]++;
                    totalBit++;
                }
            }
        }
        int gcd = -1;
        for (int i = 0; i <= 30; i++) {
            if (bitCount[i] != 0) {
                if (gcd == -1) {
                    gcd = bitCount[i];
                } else {
                    gcd = findGCD(bitCount[i], gcd);
                }
            }
        }
        if (totalBit == 0) {
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = 1; i <= gcd; i++) {
                if (gcd % i == 0) {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }

    private static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }
}