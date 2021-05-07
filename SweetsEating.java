import java.io.*;

public class SweetsEating {
    private static String resultString = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mn = readArrInt(br);
        int n = mn[0];
        int m = mn[1];
        int[] arr = readArrInt(br);
        arr = insertionSort(n, arr);
        for (int i = 1; i <= n; i++) {
            showSweetIntakeForK(i, arr, m);
        }
        System.out.println(resultString.substring(0, resultString.length() - 1));
    }

    private static int[] readArrInt(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
    }

    private static void showSweetIntakeForK(int k, int[] sortedSweets, int m) {
        int sweetIntake = 0;
        for (int i = 0; i < k; i++) {
            int day = (int) Math.ceil((double) (k - i) / m);
            sweetIntake = sweetIntake + day * sortedSweets[i];
        }
        resultString = resultString + sweetIntake + " ";
    }

    private static int[] insertionSort(int n, int[] arr) {
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
