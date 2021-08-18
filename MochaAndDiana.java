import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MochaAndDiana {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTestCase(br);
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] NM1M2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM1M2[0];
        int M1 = NM1M2[1];
        int M2 = NM1M2[2];
        int[] parent1 = new int[N + 1];
        int[] parent2 = new int[N + 1];

        int[][] M1A = new int[M1][2];
        int[][] M2A = new int[M2][2];
        for (int i = 0; i < M1; i++) {
            M1A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            union(M1A[i][0], M1A[i][1], parent1);
        }
        for (int i = 0; i < M2; i++) {
            M2A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            union(M2A[i][0], M2A[i][1], parent2);
        }

        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (find(i, parent1) == find(j, parent1) || find(i, parent2) == find(j, parent2)) continue;
                union(i, j, parent1);
                union(i, j, parent2);
                count++;
                result.append(i).append(" ").append(j).append("\n");
            }
        }
        System.out.println(count);
        System.out.println(result);
    }

    static int find(int index, int[] parents) {
        if (parents[index] == 0) {
            return index;
        } else {
            return find(parents[index], parents);
        }
    }

    static void union(int index1, int index2, int[] parents) {
        int p1 = find(index1, parents);
        int p2 = find(index2, parents);

        if (p1 < p2) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
        }
    }
}