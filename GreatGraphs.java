import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class GreatGraphs {

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestcases(br);
    }

    private static void handleMultipleTestcases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            getMinCost(N, arr);
        }
    }

    private static void getMinCost(int n, int[] arr) {
        BigInteger cost = BigInteger.valueOf(0);
        for (int i = 1; i < n; i++) {
            int pre = i;
            int post = n - i;
            int overflows = pre * post - 1;
            cost = cost.add(BigInteger.valueOf(overflows).multiply(BigInteger.valueOf(arr[i] - arr[i - 1])));
        }
        System.out.println(cost.multiply(BigInteger.valueOf(-1)));
    }
}
