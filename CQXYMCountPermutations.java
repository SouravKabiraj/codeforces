import java.io.*;
import java.util.*;

public class CQXYMCountPermutations {
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
        int N = Integer.parseInt(br.readLine());
        N = N * 2;
        long ans = 1;
        for (int i = 3; i <= N; i++) {
            ans = (ans * i) % 1000000007;
        }
        System.out.println(ans);
    }
}