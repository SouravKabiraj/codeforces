import java.io.*;
import java.util.*;

public class PermutationMinimizationByDeque {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        execute(N, A);
    }

    private static void execute(int N, int[] A) {
        Deque<Integer> ll = new LinkedList<Integer>();
        ll.add(A[0]);
        for (int i = 1; i < N; i++) {
            if (ll.getFirst() > A[i]) {
                ll.addFirst(A[i]);
            } else {
                ll.add(A[i]);
            }
        }
        for (int ele : ll) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}