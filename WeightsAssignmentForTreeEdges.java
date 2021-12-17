import java.io.*;
import java.util.*;

public class WeightsAssignmentForTreeEdges {
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
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, b, p);
    }

    private static void evaluate(int N, int[] b, int[] p) {
        int[] distance = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            int node = p[i];
            int ansester = b[node - 1];
            if (node == ansester) {
                visited[node - 1] = true;
                distance[node - 1] = 0;
            } else if (!visited[ansester - 1]) {
                System.out.println(-1);
                return;
            } else {
                visited[node - 1] = true;
                distance[node - 1] = i;
            }
        }

        for (int i = 0; i < N; i++) {
            int ansester = b[i];
            int edge = distance[i] - distance[ansester - 1];
            System.out.print(edge + " ");
        }
        System.out.println();
    }
}