import java.io.*;
import java.util.*;

public class BlueRedPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++)
            handleTest(br);
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String s = br.readLine();
        evaluate(n, a, s);
    }

    private static void evaluate(int n, int[] a, String s) {
        List<Integer> blueNumbers = new ArrayList<>();
        List<Integer> redNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') {
                blueNumbers.add(a[i]);
            } else {
                redNumbers.add(a[i]);
            }
        }
        Collections.sort(blueNumbers);
        Collections.sort(redNumbers);
        int blueI = 0;
        int redI = 0;
        for (int i = 1; i <= n; i++) {
            // System.out.println(">>" + i);
            // if (blueI < blueNumbers.size()) System.out.println("blue:" + blueI + ":" + blueNumbers.get(blueI) + " ");
            // if (redI < redNumbers.size()) System.out.println("red:" + redI + ":" + redNumbers.get(redI) + " ");

            if (blueI < blueNumbers.size() && blueNumbers.get(blueI) >= i) {
                // System.out.println("BLUE");
                blueI++;
            } else if (redI < redNumbers.size() && redNumbers.get(redI) <= i) {
                // System.out.println("RED");
                redI++;
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}