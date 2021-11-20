import java.io.*;
import java.util.*;

public class ReverseSort {
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
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        evaluate(n, input);
    }

    private static void evaluate(int n, String input) {
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == '1') ones++;
        }
        TreeSet<Integer> indexes = new TreeSet<>();
        for (int i = n - 1; i >= n - ones; i--) {
            if (input.charAt(i) == '0') {
                indexes.add(i);
            }
        }
        int zeros = indexes.size();
        if (zeros == 0) {
            System.out.println(0);
            return;
        }
        int ind = 0;
        while (zeros > 0) {
            if (input.charAt(ind) == '1') {
                indexes.add(ind);
                zeros--;
            }
            ind++;
        }
        System.out.println(1);
        System.out.print(indexes.size() + " ");
        for (int e : indexes) {
            System.out.print((e + 1) + " ");
        }
        System.out.println();
    }
}