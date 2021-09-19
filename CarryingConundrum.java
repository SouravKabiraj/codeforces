import java.io.*;
import java.util.*;

public class CarryingConundrum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int as = getNumberOfPossibility(br.readLine());
        System.out.println(as);
    }

    private static int getNumberOfPossibility(String str) {
        String str1 = "";
        String str2 = "";

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                str1 = str1 + String.valueOf(str.charAt(i));
            } else {
                str2 = str2 + String.valueOf(str.charAt(i));
            }
        }
        int num1 = 1;
        int num2 = 1;

        if (str1.length() > 0 && Integer.valueOf(str1) > 0) num1 = Integer.valueOf(str1) + 1;
        if (str2.length() > 0 && Integer.valueOf(str2) > 0) num2 = Integer.valueOf(str2) + 1;
        return num1 * num2;
    }
}