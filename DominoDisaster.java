import java.io.*;
import java.util.*;

public class DominoDisaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String row1 = br.readLine();
            printSecondLine(N, row1);
        }
    }

    private static void printSecondLine(int N, String str) {
        for (int i = 0; i < N; i++) {
            switch (str.charAt(i)) {
                case 'U':
                    System.out.print("D");
                    break;
                case 'D':
                    System.out.print("U");
                    break;
                case 'R':
                    System.out.print("R");
                    break;
                case 'L':
                    System.out.print("L");
            }
        }
        System.out.println();
    }
}