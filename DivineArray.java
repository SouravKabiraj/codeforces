import java.util.*;
import java.io.*;

public class DivineArray {
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
        int M = Integer.parseInt(br.readLine());
        int[][] xks = new int[M][2];
        int maxK = 0;
        for (int i = 0; i < M; i++) {
            xks[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        evaluate(N, A, xks);
    }

    private static void evaluate(int N, int[] A, int[][] xks) {
        int[][] AAtI = new int[N + 1][N];
        AAtI[0] = A;

        for (int i = 1; i <= N; i++) {
            Map<Integer, Integer> numCount = new HashMap<>();
            for (int j = 0; j < N; j++) {
                if (!numCount.containsKey(AAtI[i - 1][j])) {
                    numCount.put(AAtI[i - 1][j], 0);
                }
                numCount.put(AAtI[i - 1][j], numCount.get(AAtI[i - 1][j]) + 1);
            }
            for (int j = 0; j < N; j++) {
                int count = numCount.get(AAtI[i - 1][j]);
                AAtI[i][j] = count;
            }
        }

        for (int i = 0; i < xks.length; i++) {
            int x = xks[i][0] - 1;
            int k = Math.min(xks[i][1], N);
            System.out.println(AAtI[k][x]);
        }
    }
}