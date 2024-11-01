import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TilesComeback {
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
        int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(nk[1], c);
    }

    private static void evaluate(int k, int[] c) {
        int startColor = c[0];
        int endColor = c[c.length - 1];
        int lastIndexOfStartColor = c.length - 1;
        int firstIndexOfEndColor = 0;
        int countStartColor = 0;
        int countEndColor = 0;
        for (int i = 0; i < c.length; i++) {
            int ic = c[i];
            if (countStartColor + 1 == k && ic == startColor) {
                lastIndexOfStartColor = i;
                countStartColor++;
                break;
            }
            if (ic == startColor) {
                countStartColor++;
            }
        }
        if (startColor == endColor && countStartColor >= k) {
            System.out.println("YES");
            return;
        }

        for (int i = c.length - 1; i >= 0; i--) {
            int ic = c[i];
            if (countEndColor + 1 == k && ic == endColor) {
                firstIndexOfEndColor = i;
                break;
            }
            if (ic == endColor) {
                countEndColor++;
            }
        }

        if (lastIndexOfStartColor < firstIndexOfEndColor) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}