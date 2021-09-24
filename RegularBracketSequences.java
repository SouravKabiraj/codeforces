import java.io.*;
import java.util.*;

public class RegularBracketSequences {
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

    static int count;

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        generate(N);
    }

    private static void generate(int N) {
        for (int i = 0; i < N; i++) {
            generateOne(i + 1);
            generateOne(N - i - 1);
            System.out.println();
        }
    }

    private static void generateOne(int N) {
        System.out.print("(".repeat(N) + ")".repeat(N));
    }
}