import java.io.*;
import java.util.*;

public class NearestBeautifulNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NK[0];
        int K = NK[1];
        System.out.println(getMin(N, K));
    }

    private static String getMin(int n, int k) {
        boolean[] set = new boolean[10];
        String N = String.valueOf(n);
        String Res = "0".repeat(N.length());
        return getResult(N, Res, k, 0, set);
    }

    private static String getResult(String N, String R, int k, int index, boolean[] set) {
        // System.out.println(index + " " + R);
        if (index == N.length() && Integer.parseInt(N) <= Integer.parseInt(R)) {
            return R;
        } else if (index == N.length()) {
            return null;
        } else {
            for (int i = 0; i < 10; i++) {
                boolean isEleExists = set[i];
                if (!set[i] && k == 0) {
                    continue;
                }
                if (!set[i]) {
                    set[i] = true;
                    k--;
                }
                if (Integer.parseInt(N.substring(0, index + 1)) > Integer.parseInt(R.substring(0, index) + i)) {
                    if (!isEleExists) {
                        set[i] = false;
                        k++;
                    }
                    continue;
                }
                String newR = R.substring(0, index) + i + R.substring(index + 1);
                newR = getResult(N, newR, k, index + 1, set);
                if (newR != null) {
                    return newR;
                }
                if (!isEleExists) {
                    set[i] = false;
                    k++;
                }
            }
            return null;
        }
    }
}