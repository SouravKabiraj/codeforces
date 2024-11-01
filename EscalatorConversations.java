import java.io.*;
import java.util.*;

public class EscalatorConversations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] nmkH = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] h = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(nmkH[1], nmkH[2], nmkH[3], h);
    }

    private static void evaluate(int m, int k, int H, int[] h) {
        int totalConvo = 0;
        for (int hight : h) {
            if (hight == H) continue;
            if ((Math.abs(hight - H) % k) == 0) {
                if (Math.abs(hight - H) / k < m) {
                    totalConvo++;
                }
            }
        }
        System.out.println(totalConvo);
    }
}