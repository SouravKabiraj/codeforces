import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UnforgivableCurse {
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
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        evaluation(n, br.readLine(), br.readLine());
    }

    private static void evaluation(int n, String s1, String s2) {
        if (n <= 3) {
            if (s1.equals(s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            Map<Character, Integer> charCountOfS1 = new HashMap<>();
            Map<Character, Integer> charCountOfS2 = new HashMap<>();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                charCountOfS1.put(ch, 0);
                charCountOfS2.put(ch, 0);
            }
            for (int i = 0; i < n; i++) {
                charCountOfS1.put(s1.charAt(i), charCountOfS1.get(s1.charAt(i)) + 1);
                charCountOfS2.put(s2.charAt(i), charCountOfS2.get(s2.charAt(i)) + 1);
            }
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (!Objects.equals(charCountOfS1.get(ch), charCountOfS2.get(ch))) {
                    System.out.println("NO");
                    return;
                }
            }
            if (n == 4) {
                if (s1.charAt(1) != s2.charAt(1) || s1.charAt(2) != s2.charAt(2)) {
                    System.out.println("NO");
                    return;
                }
            }
            if (n == 5) {
                if (s1.charAt(2) != s2.charAt(2)) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
    }
}

/*
[1]
[12]
[123]
1[23]4
12[3]45
123456




 */