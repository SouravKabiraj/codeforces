import java.io.*;
import java.util.*;

public class PolycarpAndStringTransformation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        String str = br.readLine();
        String[] results = getInitialString(str);
        if (results.length == 0) {
            System.out.println(-1);
        } else if (!verify(results[0], results[1], str)) {
            System.out.println(-1);
        } else {
            System.out.println(results[0] + " " + results[1]);
        }
        // System.out.println("---------------------------");
    }

    private static String[] getInitialString(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        Map<Character, Integer> actualCount = new HashMap<>();
        Set<Character> distinctChar = new HashSet<>();
        int distCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (!charCount.containsKey(str.charAt(i))) {
                charCount.put(curr, 0);
                distCount++;
            }
            charCount.put(curr, charCount.get(curr) + 1);
        }
        int N = 0;
        String delSeq = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char curr = str.charAt(i);
            if (!distinctChar.contains(curr)) {
                delSeq = String.valueOf(curr) + delSeq;
                distinctChar.add(curr);
                actualCount.put(curr, charCount.get(curr) / distCount);
                N = N + (charCount.get(curr) / distCount);
                distCount--;
            }
        }

        return new String[] { str.substring(0, N), delSeq };
    }

    private static boolean verify(String act, String dis, String res) {
        String actualRst = act;
        for (int i = 0; i < dis.length(); i++) {
            // System.out.println(actualRst);
            String distChar = String.valueOf(dis.charAt(i));
            act = act.replaceAll(distChar, "");
            actualRst = actualRst + act;
        }
        return actualRst.equals(res);
    }
}