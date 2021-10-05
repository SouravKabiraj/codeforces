import java.io.*;
import java.util.*;


public class ProductiveMeeting {
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
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, A);
    }

    private static void evaluate(int N, int[] A) {
        PriorityQueue<Pair> persons = new PriorityQueue<Pair>();
        for (int i = 0; i < N; i++) {
            if (A[i] > 0)
                persons.add(new Pair(i, A[i]));
        }

        String res = "";
        int count = 0;
        while (persons.size() > 1) {
            Pair max1 = persons.poll();
            persons.remove(max1);
            Pair max2 = persons.poll();
            persons.remove(max2);
            count++;
            res = res + "\n" + (max1.x + 1) + " " + (max2.x + 1);
            if (max1.y - 1 > 0) persons.add(new Pair(max1.x, max1.y - 1));
            if (max2.y - 1 > 0) persons.add(new Pair(max2.x, max2.y - 1));
        }
        System.out.print(count);
        System.out.println(res);
    }
}


class Pair implements Comparable<Pair> {
    int y;
    int x;

    public Pair(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public int compareTo(Pair o) {
        if (this.y - o.y != 0) return -1 * (this.y - o.y);
        else return -1 * (this.x - o.x);
    }

    public String toString() {
        return (x + "," + y);
    }
}

