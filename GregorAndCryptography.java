import java.io.*;
import java.util.*;


public class GregorAndCryptography {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        printBases(N);
    }

    private static void printBases(int n) {
        HashMap<Integer, Integer> modHolder = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            int mod = n % i;
            if (modHolder.containsKey(mod)) {
                System.out.println(modHolder.get(mod) + " " + i);
                break;
            } else {
                modHolder.put(mod, i);
            }
        }
    }
}