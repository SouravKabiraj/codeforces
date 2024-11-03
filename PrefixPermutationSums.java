import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PrefixPermutationSums {
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
        Set<Long> permutation = new HashSet<>();
        long outOfTheRangeNumber = -1;
        if (a[0] > n) {
            outOfTheRangeNumber = a[0];
        } else {
            permutation.add(a[0]);
        }
        for (int i = 0; i < a.length - 1; i++) {
            long number = Math.abs(a[i + 1] - a[i]);
            if (number > n || permutation.contains(number)) {
                if (outOfTheRangeNumber != -1) {
                    System.out.println("NO");
                    return;
                }
                outOfTheRangeNumber = number;
                if ((n + (n - 1)) < outOfTheRangeNumber) {
                    System.out.println("NO");
                    return;
                }
            } else {
                permutation.add(number);
            }
        }

        Set<Long> missingPermutation = new HashSet<>();
        for (long i = 1; i <= n; i++) {
            if (!permutation.contains(i)) {
                missingPermutation.add(i);
            }
        }

        if (outOfTheRangeNumber == -1 && missingPermutation.size() == 1) {
            System.out.println("YES");
            return;
        } else if (outOfTheRangeNumber != -1 && missingPermutation.size() == 1 && outOfTheRangeNumber == missingPermutation.iterator().next()) {
            System.out.println("YES");
            return;
        } else if (outOfTheRangeNumber != -1 && missingPermutation.size() == 2) {
            var itr = missingPermutation.iterator();
            if (itr.next() + itr.next() == outOfTheRangeNumber) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}