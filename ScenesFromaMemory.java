import java.io.*;
import java.util.*;

public class ScenesFromaMemory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String NUM = br.readLine();
            getMaxRemove(NUM);
        }
    }

    private static void getMaxRemove(String num) {
        Map<Character, List<Integer>> charInd = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (!charInd.containsKey(ch)) {
                charInd.put(ch, new ArrayList<>());
            }
            charInd.get(ch).add(i);
        }
        if (charInd.containsKey('1')) {
            System.out.println("1");
            System.out.println("1");
            return;
        }
        if (charInd.containsKey('4')) {
            System.out.println("1");
            System.out.println("4");
            return;
        }
        if (charInd.containsKey('6')) {
            System.out.println("1");
            System.out.println("6");
            return;
        }
        if (charInd.containsKey('8')) {
            System.out.println("1");
            System.out.println("8");
            return;
        }
        if (charInd.containsKey('9')) {
            System.out.println("1");
            System.out.println("9");
            return;
        }
        if (charInd.containsKey('2') && (charInd.get('2').get(0) != 0 || charInd.get('2').size() > 1)) {
            System.out.println("2");
            for (int i = num.length() - 1; i >= 0; i--) {
                if (num.charAt(i) == '2') {
                    System.out.println(num.substring(i - 1, i + 1));
                    return;
                }
            }
        }
        if (charInd.containsKey('5') && (charInd.get('5').get(0) != 0 || charInd.get('5').size() > 1)) {
            System.out.println("2");
            for (int i = num.length() - 1; i >= 0; i--) {
                if (num.charAt(i) == '5') {
                    System.out.println(num.substring(i - 1, i + 1));
                    return;
                }
            }
        }
        if (charInd.containsKey('3') && charInd.get('3').size() > 1) {
            System.out.println("2");
            System.out.println("33");
            return;
        }
        if (charInd.containsKey('7') && charInd.get('7').get(charInd.get('7').size() - 1) != 0) {
            for (int i = 0; i < charInd.get('7').get(charInd.get('7').size() - 1); i++) {
                switch (num.charAt(i)) {
                    case '2':
                        System.out.println("2");
                        System.out.println("27");
                        return;
                    case '5':
                        System.out.println("2");
                        System.out.println("57");
                        return;
                    case '7':
                        System.out.println("2");
                        System.out.println("77");
                        return;
                    case '8':
                        System.out.println("2");
                        System.out.println("87");
                        return;
                }
            }
        }
    }
}