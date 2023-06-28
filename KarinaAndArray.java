import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KarinaAndArray {
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
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxInd = -1;
        int maxInd2 = -1;
        int minInd = -1;
        int minInd2 = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] >= 0 && maxInd == -1) {
                maxInd = i;
            } else if (a[i] >= 0 && maxInd2 == -1) {
                if (a[i] > a[maxInd]) {
                    maxInd2 = maxInd;
                    maxInd = i;
                } else {
                    maxInd2 = i;
                }
            } else if (a[i] >= 0 && (a[maxInd2] < a[i])) {
                if (a[maxInd] >= a[i]) {
                    maxInd2 = i;
                } else {
                    maxInd2 = maxInd;
                    maxInd = i;
                }
            }

            if (a[i] < 0 && minInd == -1) {
                minInd = i;
            } else if (a[i] < 0 && minInd2 == -1) {
                if (a[i] < a[minInd]) {
                    minInd2 = minInd;
                    minInd = i;
                } else {
                    minInd2 = i;
                }
            } else if (a[i] < 0 && (a[minInd2] > a[i])) {
                if (a[minInd] <= a[i]) {
                    minInd2 = i;
                } else {
                    minInd2 = minInd;
                    minInd = i;
                }
            }
        }

        // System.out.println(maxInd + " " + maxInd2 + " " + minInd + " " + minInd2 + " ");

        if (n == 2) {
            System.out.println((long) a[0] * (long) a[1]);
        } else if (maxInd2 == -1) {
            System.out.println((long) a[minInd] * (long) a[minInd2]);
        } else if (minInd2 == -1) {
            System.out.println((long) a[maxInd] * (long) a[maxInd2]);
        } else {
            System.out.println(Math.max((long) a[maxInd] * (long) a[maxInd2], (long) a[minInd] * (long) a[minInd2]));
        }
    }
}