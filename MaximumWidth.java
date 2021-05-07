import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaximumWidth {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTestCase(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        br.readLine();
        String str1 = br.readLine();
        String str2 = br.readLine();
        getMaxWidth(str1, str2);
    }

    private static int readInt(BufferedReader br) throws Exception {
        return Integer.parseInt(br.readLine());
    }

    private static int[] readArrInt(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
    }

    private static List<Integer> readList(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
        return arr;
    }

    private static void print(int[][] mat) {
        System.out.println("----------------------------------------");
        for (int i = 0; i < mat.length; i++) {
            System.out.print("{");
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println("----------------------------------------");
    }

    private static void print(int[] mat) {
        System.out.print("{");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println("}");
    }

    private static void getMaxWidth(String s, String t) {
        int result = 0;
        int[] pp1 = new int[t.length()];
        int[] pp2 = new int[t.length()];
        int ff = 0;
        for (int i = 0; i < s.length() && ff < t.length(); i++) {
            if (s.charAt(i) == t.charAt(ff)) {
                pp1[ff] = i;
                ff++;
            }
        }
        ff = t.length() - 1;
        for (int i = s.length() - 1; i >= 0 && ff >= 0; i--) {
            if (s.charAt(i) == t.charAt(ff)) {
                pp2[ff] = i;
                ff--;
            }
        }
        for (int i = 0; i < t.length() - 1; i++) {
            result = Math.max(result, pp2[i + 1] - pp1[i]);
        }
//        print(pp1);
//        print(pp2);
        System.out.println(result);
    }
}

