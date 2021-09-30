import java.io.*;
import java.util.*;

public class ShiftingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, A);
    }

    private static void evaluate(int n, int[] arr) {
        int count = 0;
        String result = "";
        for (int num = n; num > 1; num--) {
            int maxIndex = 1;
            for (int ind = 1; ind <= num; ind++) {
                if (arr[maxIndex - 1] < arr[ind - 1]) {
                    maxIndex = ind;
                }
            }
            int shift = maxIndex;
            if (shift % num != 0) {
                count++;
                result = result + "\n" + 1 + " " + num + " " + shift;
            }
            int[] nex = new int[n];
            for (int i = num; i < n; i++) {
                nex[i] = arr[i];
            }
            for (int ind = 1; ind <= num; ind++) {
                int newInd = (ind - shift) < 1 ? num + (ind - shift) : (ind - shift);
                nex[newInd - 1] = arr[ind - 1];
            }
            arr = nex;
        }
        System.out.print(count);
        System.out.println(result);
    }
}
