import java.io.*;
import java.util.*;

public class SlayTheDragon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleTestCase(br);
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(A);
        long total = 0;
        for (int i = 0; i < N; i++) {
            total = total + A[i];
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            long[] dragons = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            evaluate(A, dragons, total);
        }
    }

    private static void evaluate(long[] A, long[] dragons, long totalDefance) {
        long search = dragons[0];
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < search) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        long score = Long.MAX_VALUE;
        if (start != 0) {
            long score1 = search - A[start - 1];
            long score2 = dragons[1] - (totalDefance - A[start - 1]);
            score = (score1 > 0 ? score1 : 0) + (score2 > 0 ? score2 : 0);
        }
        long score1 = search - A[start];
        long score2 = dragons[1] - (totalDefance - A[start]);
        long scoreB = (score1 > 0 ? score1 : 0) + (score2 > 0 ? score2 : 0);
        score = Math.min(score, scoreB);
        System.out.println(score);
    }
}