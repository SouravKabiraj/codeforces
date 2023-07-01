import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperPermutation {
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
        evaluate(n);
    }

    private static void evaluate(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n % 2 != 0) {
            System.out.println(-1);
            return;
        }
        int[] mods = new int[n];
        int num = 0;
        int opnum = n - 1;
        for (int i = 0; i < n - 1; i = i + 2) {
            mods[i] = num;
            mods[i + 1] = opnum;
            num++;
            opnum--;
            // System.out.print(mods[i] + " " + mods[i + 1] + " ");
        }
        // System.out.println();
        System.out.print(n + " ");
        for (int i = 1; i < n; i++) {
            if (mods[i] > mods[i - 1]) {
                System.out.print((mods[i] - mods[i - 1]) + " ");
            } else {
                System.out.print(((mods[i] + n) - mods[i - 1]) + " ");
            }
        }
        System.out.println();
    }
}
