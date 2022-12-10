import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YesYes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        String str = br.readLine();
        if (validate(str))
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    private static boolean validate(String str) {
        if (str.length() == 1) {
            return str.equals("Y") || str.equals("e") || str.equals("s");
        }
        for (int i = 0; i < str.length() - 1; i++) {
            char currChar = str.charAt(i);
            switch (currChar) {
                case 'Y':
                    if (str.charAt(i + 1) != 'e') {
                        return false;
                    }
                    break;
                case 'e':
                    if (str.charAt(i + 1) != 's') {
                        return false;
                    }
                    break;
                case 's':
                    if (str.charAt(i + 1) != 'Y') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}