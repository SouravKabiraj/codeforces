import java.io.*;
import java.util.*;

public class PolycarpRecoversThePermutation {
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
        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(a);
    }

    private static void evaluate(int[] a) {
        if (!verify(a)) {
            System.out.println(-1);
            return;
        }

        LinkedList<Integer> result = new LinkedList<Integer>();
        int first = 0;
        int end = a.length - 1;
        while (first < end) {
            if (a[first] < a[end]) {
                result.addLast(a[end]);
                end--;
            } else if (a[first] > a[end]) {
                result.addFirst(a[first]);
                first++;
            }
        }
        if (result.size() > 0 && result.get(0) < a[first])
            result.addFirst(a[first]);
        else
            result.addLast(a[first]);


        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static boolean verify(int[] a) {
        if (a[0] == a.length || a[a.length - 1] == a.length) {
            return true;
        }
        return false;
    }
}