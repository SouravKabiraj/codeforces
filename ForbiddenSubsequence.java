import java.io.*;
import java.util.*;

public class ForbiddenSubsequence {
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
        String str = br.readLine();
        String seq = br.readLine();
        evaluate(seq, str);
    }

    private static void evaluate(String seq, String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }

        if (seq.equals("abc") && counts[0] != 0 && counts[1] != 0 && counts[2] != 0) {
            System.out.print(String.valueOf('a').repeat(counts[0]));
            System.out.print(String.valueOf('c').repeat(counts[2]));
            System.out.print(String.valueOf('b').repeat(counts[1]));
            for (int i = 3; i < 26; i++) {
                char ch = (char) ('a' + i);
                System.out.print(String.valueOf(ch).repeat(counts[i]));
            }
            System.out.println();
        } else {
            for (int i = 0; i < 26; i++) {
                char ch = (char) ('a' + i);
                System.out.print(String.valueOf(ch).repeat(counts[i]));
            }
            System.out.println();
        }
    }
}