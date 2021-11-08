import java.io.*;
import java.util.*;

public class TwoSubsequences {
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
        String input = br.readLine();
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(index) > input.charAt(i)) {
                index = i;
            }
        }
        System.out.print(input.charAt(index) + " ");
        for (int i = 0; i < input.length(); i++) {
            if (index != i) {
                System.out.print(input.charAt(i));
            }
        }
        System.out.println();
    }
}