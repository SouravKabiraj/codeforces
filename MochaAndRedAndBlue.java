import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MochaAndRedAndBlue {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(getOptimalString(str));
    }

    private static String getOptimalString(String str) {
        StringBuilder res1 = new StringBuilder();
        int res1Count = 0;
        char lastChar = 'R';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                if (lastChar == 'R') {
                    res1.append('B');
                    lastChar = 'B';
                } else {
                    res1.append('R');
                    lastChar = 'R';
                }
            } else {
                res1.append(str.charAt(i));
                lastChar = str.charAt(i);
            }
            if (res1.length() > 1 && res1.charAt(i) == res1.charAt(i - 1)) {
                res1Count++;
            }
        }
        StringBuilder res2 = new StringBuilder();
        int res2Count = 0;
        lastChar = 'B';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                if (lastChar == 'R') {
                    res2.append('B');
                    lastChar = 'B';
                } else {
                    res2.append('R');
                    lastChar = 'R';
                }
            } else {
                res2.append(str.charAt(i));
                lastChar = str.charAt(i);
            }
            if (res2.length() > 1 && res2.charAt(i) == res2.charAt(i - 1)) {
                res2Count++;
            }
        }

        if (res1Count < res2Count) {
            return res1.toString();
        } else {
            return res2.toString();
        }
    }
}