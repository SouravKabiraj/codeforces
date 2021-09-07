import java.io.*;
import java.util.*;

public class Rings {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        printIndexes(N, str);
    }

    private static void printIndexes(int n, String str) {
        int firstZero = -1;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') {
                firstZero = i;
                break;
            }
        }
        int M = (n / 2) - 1;
        if (firstZero <= M) {
            System.out.println((firstZero + 1) + " " + n + " " + (firstZero + 2) + " " + n);
        } else {
            System.out.println(1 + " " + firstZero + " " + 1 + " " + (firstZero + 1));
        }
    }
}