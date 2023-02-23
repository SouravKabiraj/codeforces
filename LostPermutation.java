import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LostPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++)
            handleTest(br);
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] ms = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = ms[0];
        int s = ms[1];
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        execute(m, s, b);
    }

    private static void execute(int m, int s, int[] b) {
        int max = 0;
        int sumWithOutOmittedNumber = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, b[i]);
            sumWithOutOmittedNumber = sumWithOutOmittedNumber + b[i];
        }
        int sumWithOmittedNumber = max * (max + 1) / 2;
        int gapSum = sumWithOmittedNumber - sumWithOutOmittedNumber;
        if (s == gapSum) {
            System.out.println("YES");
            return;
        }
        if (s < gapSum) {
            System.out.println("NO");
            return;
        }
        s = s - gapSum;
        for (int ele = max + 1; ; ele++) {
            if (s == 0) {
                System.out.println("YES");
                return;
            }
            if (s < 0) {
                System.out.println("NO");
                return;
            }
            s = s - ele;
        }
    }
}