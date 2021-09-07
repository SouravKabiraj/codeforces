import java.io.*;
import java.util.*;

public class A_The_Miracle_and_the_Sleeper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws NumberFormatException, IOException {
        long[] inps = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::valueOf).toArray();
        long l = inps[0];
        long r = inps[1];
        // System.out.println(l + " " + r);
        long low = Math.max(((r / 2) + 1), l);
        System.out.println(r % low);
    }
}