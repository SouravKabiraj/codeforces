import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoamenAndKsubarrays {
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
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean flag = isPossible(NK[0], NK[1], A);
        System.out.println(flag ? "YES" : "NO");
    }

    private static boolean isPossible(int n, int k, int[] a) {
        List<Tuple> tuples = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tuples.add(new Tuple(a[i], i));
        }
        Collections.sort(tuples);
        k--;
        for (int i = 1; i < n; i++) {
            if (tuples.get(i - 1).index + 1 != tuples.get(i).index) {
                k--;
            }
            if (k < 0) {
                return false;
            }
        }
        return true;
    }
}

class Tuple implements Comparable<Tuple> {
    int ele;
    int index;

    Tuple(int e, int i) {
        ele = e;
        index = i;
    }

    @Override
    public int compareTo(Tuple o) {
        return ele - o.ele;
    }
}