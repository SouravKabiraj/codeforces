import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class DivisionByTwoAndPermutation {
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
        IntStream a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt);
        evaluate(n, a);
    }

    private static void evaluate(int n, IntStream a) {
        boolean[] isUsed = new boolean[n + 1];
        IntUnaryOperator ops = value -> {
            while (value > n) value = value / 2;
            return value;
        };
        IntPredicate predicate = value -> {
            while (isUsed[value] && value > 0) {
                value = value / 2;
            }
            if (value <= 0) return false;
            isUsed[value] = true;
            return true;
        };
        System.out.println(a.map(ops).allMatch(predicate) ? "YES" : "NO");
    }
}