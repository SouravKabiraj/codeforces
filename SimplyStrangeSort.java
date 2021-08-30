import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SimplyStrangeSort {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCases(br);
        }
    }

    private static void handleTestCases(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int R = getCount(N, A);
        System.out.println(R);
    }

    private static int getCount(int n, int[] a) {
        int count = 0;
        while (!(isSortedArray(a))) {
            count++;
            sort(n, a, (count % 2 == 1));
        }
        return count;
    }

    private static void sort(int n, int[] a, boolean isOdd) {
        // System.out.println(isOdd ? "odd" : "even");
        for (int i = 0; i < n - 1; i++) {
            if (((isOdd && i % 2 == 0) || (!isOdd && i % 2 == 1)) && a[i] > a[i + 1]) {
                // System.out.print((i + 1) + " ");
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        // System.out.println();
    }

    private static boolean isSortedArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            // System.out.print(a[i] + " ");
            if (a[i] != i + 1) {
                return false;
            }
        }
        // System.out.println();
        return true;
    }
}
