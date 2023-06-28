import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TubeTubeFeed {
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
        int[] nt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nt[0];
        int t = nt[1];
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(n, t, a, b);
    }

    private static void evaluate(int n, int t, int[] durations, int[] entertainment) {
        int maxEntInd = -1;
        for (int i = 0; i < n; i++) {
            durations[i] = durations[i] + i;
            if (durations[i] <= t && (maxEntInd < 0 || entertainment[maxEntInd] < entertainment[i])) {
                maxEntInd = i;
            }
        }
        System.out.println(maxEntInd == -1 ? maxEntInd : maxEntInd + 1);
    }
}