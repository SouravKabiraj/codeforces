import java.util.*;
import java.io.*;

public class DeepDownBelow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCases(br);
        }
    }

    private static void handleTestCases(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        TreeSet<Cave> caves = new TreeSet<>();
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int K = A[0];
            int entryPoint = 0;
            for (int a = 0; a < K; a++) {
                entryPoint = Math.max(entryPoint, A[a + 1] + 1 - a);
            }
            l = Math.min(l, entryPoint);
            r = Math.max(r, entryPoint);
            caves.add(new Cave(entryPoint, K));
        }

        long power = 0;
        long int_power = 0;
        for (Cave c : caves) {
            if (power < c.entry) {
                int_power += c.entry - power;
                power += c.entry - power;
            }
            power += c.kill;
        }

        System.out.println(int_power);
    }
}

class Cave implements Comparable<Cave> {
    int entry;
    int kill;

    Cave(int entry, int kill) {
        this.entry = entry;
        this.kill = kill;
    }

    public int compareTo(Cave o) {
        if (entry == o.entry) {
            return o.kill - kill;
        }
        return entry - o.entry;
    }
}