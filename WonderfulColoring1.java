import java.io.*;
import java.util.*;

public class WonderfulColoring1 {
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
        String text = br.readLine();
        color(text);
    }

    private static void color(String text) {
        HashMap<Character, List<Integer>> charIndex = new HashMap<>();
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (!charIndex.containsKey(text.charAt(i))) {
                charIndex.put(text.charAt(i), new ArrayList<>());
            }
            if (charIndex.get(text.charAt(i)).size() < 2) {
                charIndex.get(text.charAt(i)).add(i);
                count++;
            }
        }
        count = count / 2;
        System.out.println(count);
    }
}