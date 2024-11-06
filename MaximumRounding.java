import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumRounding {
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
        String number = br.readLine();
        evaluate(number);
    }

    private static void evaluate(String number) {
        char[] result = new char[number.length()];
        boolean carry = false;
        for (int i = number.length() - 1; i >= 0; i--) {
            char ch = number.charAt(i);
            if (carry && ch == '9') {
                result[i] = '*';
                continue;
            }
            if (carry) {
                ch = (char) (ch + 1);
                carry = false;
            }

            if (ch > '4') {
                result[i] = '*';
                carry = true;
            } else {
                result[i] = ch;
            }
        }
        if (carry) {
            System.out.print("1");
        }
        boolean rounded = false;
        for (char c : result) {
            if (c == '*') rounded = true;
            System.out.print(rounded ? "0" : c);
        }
        System.out.println();
    }
}