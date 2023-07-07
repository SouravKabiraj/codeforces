import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakingAntiPalindromes {
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
        String str = br.readLine();
        evaluate(n, str);
    }

    private static void evaluate(int n, String str) {
        if (n % 2 == 1) {
            System.out.println(-1);
            return;
        }
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int i = 0; i < n; i++) {
            freq[str.charAt(i) - 'a']++;
            maxFreq = Math.max(maxFreq, freq[str.charAt(i) - 'a']);
            if (maxFreq * 2 > n) {
                System.out.println(-1);
                return;
            }
        }
        int totalPal = 0;
        int maxPalFreq = 0;
        int[] palFreq = new int[26];
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) == str.charAt(n - i - 1)) {
                totalPal++;
                palFreq[str.charAt(i) - 'a']++;
            }
            maxPalFreq = Math.max(maxPalFreq, palFreq[str.charAt(i) - 'a']);
        }
        System.out.println(Math.max(((totalPal + 1) / 2), maxPalFreq));
    }
}

