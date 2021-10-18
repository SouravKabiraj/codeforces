import java.io.*;
import java.util.*;

public class MakeThemEqual {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        String[] line1 = br.readLine().split(" ");
        String line2 = br.readLine();
        int n = Integer.parseInt(line1[0]);
        int ch = line1[1].charAt(0);
        if (n == 1 && line2.charAt(0) == ch) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            System.out.println(1);
            return;
        } else if (n == 2 && line2.charAt(0) == ch && line2.charAt(1) == ch) {
            System.out.println(0);
            return;
        } else if (n == 2 && line2.charAt(0) != ch && line2.charAt(1) == ch) {
            System.out.println(1);
            System.out.println(1);
            return;
        } else if (n == 2 && line2.charAt(0) == ch && line2.charAt(1) != ch) {
            System.out.println(1);
            System.out.println(2);
            return;
        } else if (n == 2) {
            System.out.println(2);
            System.out.println("1 2");
            return;
        }
        int mid = n / 2;
        int indexWithCh = -1;
        boolean allChar = true;
        for (int i = 0; i < n; i++) {
            if (line2.charAt(i) != ch) {
                allChar = false;
                break;
            }
        }
        if (allChar) {
            System.out.println(0);
            return;
        }
        for (int i = mid; i < n; i++) {
            // System.out.println(">>" + line2.charAt(i));
            if (line2.charAt(i) == ch) {
                indexWithCh = i;
                break;
            }
        }
        if (indexWithCh != -1) {
            System.out.println(1);
            System.out.println(indexWithCh + 1);
        } else {
            System.out.println(2);
            System.out.println((mid + 1) + " " + (mid + 2));
        }
    }
}