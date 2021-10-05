import java.io.*;
import java.util.*;

public class ArrayOptimizationByDeque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, A);
    }

    private static void evaluate(int N, int[] A) {
        List<Integer> prevIndex = new ArrayList<>();
        int[] size = new int[N];

        for (int i = 0; i < N; i++) {
            while (prevIndex.size() > 0 && A[prevIndex.get(prevIndex.size() - 1)] < A[i]) {
                prevIndex.remove(prevIndex.size() - 1);
            }
            if (prevIndex.size() == 0) {
                prevIndex.add(i);
                size[i] = 1;
            } else {
                size[i] = size[prevIndex.get(prevIndex.size() - 1)] + 1;
                prevIndex.add(i);
            }
            System.out.println(">" + prevIndex);
            System.out.println(">>" + size[i] + " ");
        }
    }
}

/*
3  7  5 5
-1 -1 1 1

3  7  5 5 8   9
-1 -1 1 1 -1 -1
0  0  1 1 0   0


 */