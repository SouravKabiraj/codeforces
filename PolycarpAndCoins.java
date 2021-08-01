import java.util.*;
import java.io.*;

public class PolycarpAndCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        printDistribution(N);
    }

    private static void printDistribution(int n) {
        if (n % 3 == 0) {
            System.out.println((n / 3) + " " + (n / 3));
        } else if (n % 3 == 1) {
            System.out.println(((n / 3) + 1) + " " + (n / 3));
        } else {
            System.out.println((n / 3) + " " + ((n / 3) + 1));
        }
    }
}