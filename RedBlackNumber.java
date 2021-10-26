import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class RedBlackNumber {
    public static void main(String[] agrs) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        IntStream.range(0, T).forEach((i) -> handleTest(br));
    }

    private static void handleTest(BufferedReader br) {
        try {
            int[] nAB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nAB[0];
            int A = nAB[1];
            int B = nAB[2];
            String input = br.readLine();
            String symbol = getSymbol(input, A, B, n);
            System.out.println(symbol.equals("") ? -1 : symbol);
        } catch (IOException e) {
        }
    }

    private static String getSymbol(String input, int A, int B, int n) {
        long max = (long) Math.pow(2, n + 1);
        int diff = n;
        String ANS = "";
        for (long i = 1; i <= max / 2; i++) {
            String ans = "";
            String invans = "";
            int anum = 0;
            int aCount = 0;
            int bnum = 0;
            int bCount = 0;

            for (int k = 1; k <= n; k++) {
                int currChar = input.charAt(k - 1) - '0';
                if (((1 << k) & i) == 0) {
                    anum = anum * 10 + currChar;
                    aCount++;
                    ans = ans + "R";
                    invans = invans + "B";
                } else {
                    bnum = bnum * 10 + currChar;
                    bCount++;
                    ans = ans + "B";
                    invans = invans + "R";
                }
            }

            if (anum % A == 0 && bnum % B == 0 && Math.abs(aCount - bCount) < diff) {
                ANS = ans;
                diff = Math.abs(aCount - bCount);
            }
            if (anum % B == 0 && bnum % A == 0 && Math.abs(aCount - bCount) < diff) {
                ANS = invans;
                diff = Math.abs(aCount - bCount);
            }
        }
        return ANS;
    }

}