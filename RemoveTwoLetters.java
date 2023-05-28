import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RemoveTwoLetters {
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
        List<Char> chars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int lastI = i;
            while (i + 1 < n && str.charAt(lastI) == str.charAt(i + 1)) {
                i++;
            }
            if (lastI != i) {
                chars.add(new Char(str.charAt(lastI), true));
            } else {
                chars.add(new Char(str.charAt(lastI), false));
            }
        }
        int count = chars.size() - 1;
        for (Char c : chars) {
            if (c.multi) {
                count++;
            }
        }

        for (int i = 0; i < n - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 2) && str.charAt(i) != str.charAt(i + 1)) {
                count--;
            }
        }

        System.out.println(count);
    }
}

class Char {
    char ch;
    boolean multi;

    @Override
    public String toString() {
        return "[CH:" + ch + " MU:" + multi + "]";
    }

    Char(char ch, boolean multi) {
        this.ch = ch;
        this.multi = multi;
    }
}