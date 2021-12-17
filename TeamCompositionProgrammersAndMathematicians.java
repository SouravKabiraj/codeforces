import java.io.*;
import java.util.*;

public class TeamCompositionProgrammersAndMathematicians {
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
        int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(evaluate((long) ab[0], (long) ab[1]));
    }

    private static long evaluate(long a, long b) {
        long d = 0;
        if (a == b) {
            return (a + b) / 4;
        } else {
            if (a < b) {
                long temp = a;
                a = b;
                b = temp;
            }
            d = a - b;
            a -= d;
            d /= 2;
            d = Math.min(a, d);
            a -= d;
            b -= d;
            d += (a + b) / 4;
            return d;
        }

    }
}

