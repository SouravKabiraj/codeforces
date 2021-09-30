import java.io.*;

public class CasimirsStringSolitaire {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            evaluate(str);
        }
    }

    private static void evaluate(String str) {
        int A = 0;
        int B = 0;
        int C = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'A':
                    A++;
                    break;
                case 'B':
                    B++;
                    break;
                case 'C':
                    C++;
                    break;
            }
        }
        if (A + C == B) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}