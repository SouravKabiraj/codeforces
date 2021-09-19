import java.io.*;
import java.util.*;

public class ExpressionEvaluationError {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        long[] sn = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long s = sn[0];
        int n = (int) sn[1];
        List<Long> result = new ArrayList<Long>();
        getArray(s, n, result);
        StringBuffer str = new StringBuffer();
        result.forEach(a -> {
            str.append(a + " ");
        });
        System.out.println(str);
    }

    private static boolean getArray(long s, int n, List<Long> result) {
        if (n == 1 && s > 0) {
            result.add(s);
            return true;
        } else if (n == 1 && s <= 0) {
            return false;
        } else if (s <= 0) {
            return false;
        }
        long tens = 1;
        while (s / tens != 0) {
            tens = tens * 10;
        }
        tens = tens / 10;
        result.add(tens);
        if (getArray(s - tens, n - 1, result)) {
            return true;
        }
        result.remove(result.size() - 1);
        tens = tens / 10;
        if (tens == 0) {
            return false;
        }
        result.add(tens);
        if (getArray(s - tens, n - 1, result)) {
            return true;
        }
        return false;
    }
}