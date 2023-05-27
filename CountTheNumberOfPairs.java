import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountTheNumberOfPairs {
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
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String str = br.readLine();
        evaluate(nk[0], nk[1], str);
    }

    private static void evaluate(int N, int K, String str) {
        int[] uppercaseCount = new int[26];
        int[] lowercaseCount = new int[26];
        int point = 0;
        for (int i = 0; i < N; i++) {
            int currChar = str.charAt(i);
            if (currChar >= 'A' && currChar <= 'Z') {
                uppercaseCount[currChar - 'A']++;
            } else {
                lowercaseCount[currChar - 'a']++;
            }
        }
        for (int ch = 0; ch < 26; ch++) {
            point = point + Math.min(uppercaseCount[ch], lowercaseCount[ch]);
            int extras = Math.abs(uppercaseCount[ch] - lowercaseCount[ch]);
            if (extras > 0) {
                int extrasPoints = extras / 2;
                if (extrasPoints >= K) {
                    point = point + K;
                    K = 0;
                } else {
                    K = K - extrasPoints;
                    point = point + extrasPoints;
                }
            }
        }
        System.out.println(point);
    }
}