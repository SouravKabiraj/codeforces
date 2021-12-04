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
        if ((a > 0) && ((3 * a) <= b)) {
            return a;
        } else if ((b > 0) && ((3 * b) <= a)) {
            return b;
        } else if (a >= 2 && b >= 2) {
            long teams = Math.min(a / 2, b / 2);
            return teams + evaluate(a - 2 * teams, b - 2 * teams);
        } else if (a >= 3 && b >= 1) {
            return 1 + evaluate(a - 3, b - 1);
        } else if (b >= 3 && a >= 1) {
            return 1 + evaluate(a - 1, b - 3);
        } else {
            return 0;
        }
    }
}

