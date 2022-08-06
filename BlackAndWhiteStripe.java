import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BlackAndWhiteStripe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = NK[1];
        String s = br.readLine();
        evaluate(k, s);
    }

    private static void evaluate(int k, String s) {
        int minChange = 0;
        for (int i = 0; i < k; i++) {
            minChange = s.charAt(i) != 'B' ? minChange + 1 : minChange;
        }
        int head = 0;
        int tail = k;

        int newChange = minChange;
        while (tail < s.length()) {
            if (s.charAt(tail) == 'B') {
                newChange--;
            }
            if (s.charAt(head) == 'B') {
                newChange++;
            }
            minChange = Math.min(minChange, newChange);
            head++;
            tail++;
        }
        System.out.println(minChange);
    }
}