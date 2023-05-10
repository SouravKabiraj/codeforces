import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Matryoshkas {
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
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(A);
        evaluate(N, A);
    }

    private static void evaluate(int N, int[] arr) {
        HashMap<Integer, Integer> eleFreq = new HashMap<>();
        int eleCount = 0;
        for (int i = 0; i < N; i++) {
            if (!eleFreq.containsKey(arr[i])) {
                eleCount++;
                eleFreq.put(arr[i], 0);
            }
            eleFreq.put(arr[i], eleFreq.get(arr[i]) + 1);
        }
        int[][] eleWithFreq = new int[eleCount][2];
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            eleWithFreq[index][0] = arr[i];
            eleWithFreq[index][1] = eleFreq.get(arr[i]);
            // System.out.println(index + " >> " + eleWithFreq[index][0] + " - " + eleWithFreq[index][1]);
            index++;
        }

        int result = eleWithFreq[0][1];
        for (int i = 1; i < eleCount; i++) {
            // System.out.println(eleWithFreq[i][0] + " " + (eleWithFreq[i - 1][0] + 1));
            if ((eleWithFreq[i][0] == eleWithFreq[i - 1][0] + 1) && eleWithFreq[i][1] <= eleWithFreq[i - 1][1]) {
                // System.out.println("c1");
                continue;
            } else if ((eleWithFreq[i][0] == eleWithFreq[i - 1][0] + 1)) {
                // System.out.println("c2");
                result = result + (eleWithFreq[i][1] - eleWithFreq[i - 1][1]);
            } else {
                // System.out.println("c3");
                result = result + eleWithFreq[i][1];
            }
        }
        System.out.println(result);
    }
}

