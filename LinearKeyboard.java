import java.io.*;
import java.util.*;

public class LinearKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMutiTest(br);
    }

    private static void handleMutiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int count = 0;
        String pattern = br.readLine();
        String word = br.readLine();
        int[] ch = new int[26];
        for (int i = 0; i < 26; i++) {
            int charInt = pattern.charAt(i) - 'a';
            ch[charInt] = i;
        }
        for (int i = 1; i < word.length(); i++) {
            int charInt2 = word.charAt(i) - 'a';
            int charInt1 = word.charAt(i - 1) - 'a';
            count = count + Math.abs(ch[charInt2] - ch[charInt1]);
        }
        System.out.println(count);
    }
}