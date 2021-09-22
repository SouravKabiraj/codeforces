import java.io.*;
import java.util.*;

public class Swaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultiTestCase(br);
    }

    private static void handleMultiTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getMinSwap(N, A, B));
    }

    private static int getMinSwap(int N, int[] A, int[] B) {
        int[] positions = new int[N * 2 + 1];
        boolean[] isA = new boolean[N * 2 + 1];
        for (int i = 0; i < A.length; i++) {
            positions[A[i]] = i;
            isA[A[i]] = true;
            positions[B[i]] = i;
        }
        int minB = N;
        int minA = N;
        for (int i = 1; i < N * 2 + 1; i++) {
            if (!isA[N * 2 + 1 - i]) {
                minB = Math.min(minB, positions[N * 2 + 1 - i]);
                positions[N * 2 + 1 - i] = minB;
            }
            if (isA[i]) {
                minA = Math.min(minA, positions[i]);
                positions[i] = minA;
            }
        }

        int res = N + 1;
        for (int i = 1; i < N * 2; i++) {
            if (isA[i] && !isA[i + 1])
                res = Math.min(res, positions[i] + positions[i + 1]);
        }
        return res;
    }
}