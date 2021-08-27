import java.io.*;
import java.util.*;

public class InfinityTable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] res = getPosition(num);
            System.out.println(res[0] + " " + res[1]);
        }
    }

    private static int[] getPosition(int num) {
        int start = 1;
        int col = 0;
        int size = 1;
        while (start <= num) {
            start = size + start;
            col++;
            size = size + 2;
        }
        size = size - 2;
        start = start - size;

        if (num < start + col) {
            return new int[]{(num - start + 1), col};
        } else {
            return new int[]{col, (col - (num - (start + col - 1)))};
        }
    }
}