import java.io.*;
import java.util.*;

public class NonZeroSegments {
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTestCase(br);
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        readInt(br);
        int[] a = readArrInt(br);
        getCountOfNonZeroSegments(a);
    }

    private static int readInt(BufferedReader br) throws Exception {
        return Integer.parseInt(br.readLine());
    }

    private static int[] readArrInt(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
    }

    private static void getCountOfNonZeroSegments(int[] a) {
        int count = 0;
        int sum = 0;
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sums.contains(sum)) {
                count++;
                sums.clear();
                sums.add(0);
                sums.add(a[i]);
                sum = a[i];
            } else {
                sums.add(sum);
            }
        }
        System.out.println(count);
    }
}
