import java.io.*;
import java.util.*;

public class MochaAndHiking {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleSingleTestCase(br);
        }
    }

    private static void handleSingleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (A[0] == 1) {
            System.out.print((N + 1) + " ");
            for (int i = 1; i <= N; i++) {
                System.out.print(i + " ");
            }
        } else {
            int index = -1;
            for (int i = 0; i < N - 1; i++) {
                if (A[i] == 0 && A[i + 1] == 1) {
                    index = i + 1;
                }
            }
            if (index == -1) {
                for (int i = 1; i < N + 2; i++) {
                    System.out.print(i + " ");
                }
            } else {
                for (int i = 1; i <= index; i++) {
                    System.out.print(i + " ");
                }
                System.out.print((N + 1) + " ");

                for (int i = index + 1; i < N + 1; i++) {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }
}
