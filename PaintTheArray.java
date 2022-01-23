import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaintTheArray {
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
        int n = Integer.parseInt(br.readLine());
        long[] a = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        evaluate(n, a);
    }

    private static void evaluate(int n, long[] a) {
        List<Long> odds = new ArrayList<>();
        List<Long> evens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evens.add(a[i]);
            } else {
                odds.add(a[i]);
            }
        }
        long gcdOfOdds = GcdOfArray(odds, 0);
        long gcdOfEvens = GcdOfArray(evens, 0);
        boolean oddFlag = true;
        boolean evenFlag = true;
        for (int i = 0; i < odds.size(); i++) {
            if (odds.get(i) % gcdOfEvens == 0) {
                evenFlag = false;
            }
        }
        for (int i = 0; i < evens.size(); i++) {
            if (evens.get(i) % gcdOfOdds == 0) {
                oddFlag = false;
            }
        }

        if (oddFlag) {
            System.out.println(gcdOfOdds);
        } else if (evenFlag) {
            System.out.println(gcdOfEvens);
        } else {
            System.out.println(0);
        }
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long GcdOfArray(List<Long> arr, int idx) {
        if (idx == arr.size() - 1) {
            return arr.get(idx);
        }
        long a = arr.get(idx);
        long b = GcdOfArray(arr, idx + 1);
        return gcd(a, b);
    }
}