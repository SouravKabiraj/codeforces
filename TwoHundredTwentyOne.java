import java.io.*;
import java.util.*;

public class TwoHundredTwentyOne {
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
        int[] sn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = sn[0];
        int n = sn[1];
        String str = br.readLine();
        int[][] q = new int[n][2];
        for (int i = 0; i < n; i++) {
            q[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        execute(str, q);
    }

    private static void execute(String str, int[][] q) {
        int N = str.length();
        int[] inp1 = new int[N];

        for (int i = 0; i < N; i++) {
            int ele = i % 2 == 0 ? 1 : -1;
            inp1[i] = i == 0 ? (str.charAt(i) == '+' ? ele : -1 * ele) : (str.charAt(i) == '+' ? inp1[i - 1] + ele : inp1[i - 1] - ele);
            // System.out.print(inp1[i] + " ");
        }
        // System.out.println();

        for (int i = 0; i < q.length; i++) {
            int l = q[i][0] - 1;
            int r = q[i][1] - 1;

            if ((l == 0 && inp1[r] == 0) || (l > 0 && inp1[r] - inp1[l - 1] == 0)) {
                System.out.println(0);
            } else if ((r - l + 1) % 2 == 0) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }
}