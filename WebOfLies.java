import java.io.*;
import java.util.*;

public class WebOfLies {
    public static void main(String[] arg) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTestCase(br);
    }

    static void handleTestCase(BufferedReader br) throws IOException {
        int[] MN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = MN[0];
        int M = MN[1];
        int[] friends = new int[N];
        count = N;

        for (int i = 0; i < M; i++) {
            int[] AB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int A = Math.min(AB[0], AB[1]);
            add(A, friends);
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            switch (input.charAt(0)) {
                case '1':
                    int[] AB = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                    int A = Math.min(AB[1], AB[2]);
                    add(A, friends);
                    break;
                case '2':
                    AB = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                    A = Math.min(AB[1], AB[2]);
                    remove(A, friends);
                    break;
                default:
                    process();
            }
        }
    }

    private static void process() {
        System.out.println(count);
    }

    private static void remove(int a, int[] friends) {
        a--;
        friends[a]--;
        if (friends[a] == 0) {
            count++;
        }
    }

    private static void add(int a, int[] friends) {
        a--;
        if (friends[a] == 0) {
            count--;
        }
        friends[a]++;
    }

    private static int count = 0;
}
