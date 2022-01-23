import java.io.*;

public class MissingBigram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] bigrams = br.readLine().split(" ");
        evaluate(bigrams);
    }

    private static void evaluate(String[] bigrams) {
        int n = bigrams.length;
        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            if (bigrams[i].charAt(1) != bigrams[i + 1].charAt(0)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.print("a");
            for (String bigram : bigrams) {
                System.out.print(bigram.charAt(0));
            }
            System.out.println(bigrams[n - 1].charAt(1));
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(bigrams[i].charAt(0));
                if (index == i) {
                    System.out.print(bigrams[i].charAt(1));
                }
            }
            System.out.println(bigrams[n - 1].charAt(1));
        }
    }
}
