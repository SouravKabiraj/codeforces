import java.io.*;
import java.util.*;

public class CharmedByTheGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] AB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = AB[0];
        int B = AB[1];
        getAllBreaks(A, B);
    }

    private static void getAllBreaks(int A, int B) {
        int oddPos, evenPos;
        oddPos = (A + B) / 2;
        evenPos = (A + B - oddPos);
        TreeSet<Integer> ways = new TreeSet<>();

        for (int i = 0; i <= oddPos; i++) {
            int a_0 = i;
            int a_1 = A - i;
            int b_0 = oddPos - a_0;
            int b_1 = evenPos - a_1;

            if ((a_1) < 0 || b_0 < 0 || b_1 < 0) continue;

            ways.add(a_0 + b_1);
        }

        for (int i = 0; i <= evenPos; i++) {
            int a_1 = i;
            int a_0 = A - i;
            int b_0 = oddPos - a_0;
            int b_1 = evenPos - a_1;
            if ((a_1) < 0 || (a_0) < 0 || b_0 < 0 || b_1 < 0) continue;
            ways.add(a_1 + b_0);
        }
        System.out.println(ways.size());
        ways.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
    }
}
