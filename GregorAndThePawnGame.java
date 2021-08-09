import java.io.*;

public class GregorAndThePawnGame {
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

        boolean[] myTeam = new boolean[N];
        boolean[] opTeam = new boolean[N];

        String op = br.readLine();
        String my = br.readLine();

        for (int i = 0; i < N; i++) {
            myTeam[i] = my.charAt(i) == '1';
            opTeam[i] = op.charAt(i) == '1';
        }

        int res = findReaches(N, myTeam, opTeam);
        System.out.println(res);
    }

    private static int findReaches(int n, boolean[] myTeam, boolean[] opTeam) {
        boolean[] placed = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (myTeam[i]) {
                if (i > 0 && opTeam[i - 1] && !placed[i - 1]) {
                    opTeam[i - 1] = false;
                    placed[i - 1] = true;
                    count++;
                } else if (!placed[i] && !opTeam[i]) {
                    placed[i] = true;
                    count++;
                } else if (i < (n - 1) && opTeam[i + 1] && !placed[i + 1]) {
                    opTeam[i + 1] = false;
                    placed[i + 1] = true;
                    count++;
                }
            }
        }
        return count;
    }
}