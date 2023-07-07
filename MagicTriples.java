import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;


public class MagicTriples {
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
        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, a);
    }

    private static void evaluate(int n, int[] a) {
        int[] numCount = new int[1000001];
        Set<Integer> numbers = new HashSet<>();
        int maxnum = 0;
        for (int i = 0; i < n; i++) {
            numCount[a[i]]++;
            maxnum = Math.max(maxnum, a[i]);
            numbers.add(a[i]);
        }
        long result = 0;

        for (int num : numbers) {
            for (int b = 2; b <= 1000 && (num * b * b) <= 1000000; b++) {
                result = result + (long) numCount[num] * (long) (numCount[num * b]) * (long) (numCount[num * b * b]);
            }
            if (numCount[num] > 2) {
                result = result + (long) numCount[num] * (long) (numCount[num] - 1) * (long) (numCount[num] - 2);
            }
        }
        System.out.println(result);
    }
}