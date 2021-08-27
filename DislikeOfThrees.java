import java.io.*;
import java.util.*;

public class DislikeOfThrees {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int[] K = new int[T];
        int[] ans = new int[2000];
        int max = 0;
        for (int i = 0; i < T; i++) {
            K[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, K[i]);
        }
        int count = 1;
        int num = 1;
        while (count <= max) {
            if (num % 3 == 0) {
                num++;
            } else if (num % 10 == 3) {
                num++;
            } else {
                ans[count] = num;
                count++;
                num++;
            }
        }
        Arrays.stream(K).forEach(k -> System.out.println(ans[k]));
    }
}