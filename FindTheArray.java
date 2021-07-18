import java.io.*;

public class FindTheArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
        int count = 1;
        N--;
        int lastUse = 1;
        while (N > 0) {
            if (lastUse + 2 <= N) {
                count++;
                N = N - (lastUse + 2);
                lastUse = lastUse + 2;
            } else if (lastUse + 1 <= N) {
                count++;
                N = N - (lastUse + 1);
                lastUse = lastUse + 1;
            } else {
                count++;
                N = 0;
            }
        }
        System.out.println(count);
    }
}