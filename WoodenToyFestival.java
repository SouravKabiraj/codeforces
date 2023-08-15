import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WoodenToyFestival {
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
        Arrays.sort(a);
        evaluate(n, a);
    }

    private static void evaluate(int n, int[] a) {
        int low = 0;
        int high = 1000000000;
        int result = high;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isAchievable(mid, a, n)) {
                result = mid;
                high = mid - 1;
                // System.out.println(mid + " is achievable...");
            } else {
                low = mid + 1;
                // System.out.println(mid + " is not achievable...");
            }
        }
        System.out.println(result);
    }

    private static boolean isAchievable(int y, int[] a, int n) {
        int endRangeOfCarvers1 = a[0] + 2 * y;
        int firstIndexOfCarvers2 = Math.min((binarySearchImmediateLower(a, endRangeOfCarvers1) + 1), n - 1);
        int endRangeOfCarvers2 = a[firstIndexOfCarvers2] + 2 * y;
        int firstIndexOfCarvers3 = Math.min((binarySearchImmediateLower(a, endRangeOfCarvers2) + 1), n - 1);
        int endRangeOfCarvers3 = a[firstIndexOfCarvers3] + 2 * y;
        return endRangeOfCarvers3 >= a[n - 1];
    }


    public static int binarySearchImmediateLower(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1; // Initialize the result to -1, indicating no immediate lower element

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                result = mid; // Update the result to the current index before moving right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}