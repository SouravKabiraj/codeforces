import java.io.*;
import java.util.*;

public class MakeEven {
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
        String s = br.readLine();
        int N = s.length();
        int lastChar = s.charAt(N - 1) - '0';
        int firstChar = s.charAt(0) - '0';
        if (lastChar % 2 == 0) {
            System.out.println(0);
            return;
        }
        if (firstChar % 2 == 0) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < N; i++) {
            int ch = s.charAt(i) - '0';
            if (ch % 2 == 0) {
                System.out.println(2);
                return;
            }
        }
        System.out.println(-1);
        return;
    }
}