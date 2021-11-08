import java.io.*;
import java.util.*;

public class FrogTraveler {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTest(br);
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] jumps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] slips = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] DP = new int[N];
        List<Integer> indes = new ArrayList<>();
        List<Integer> steps = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        indes.add(N - 1);
        steps.add(1);
        prev.add(-1);
        DP[N - 1] = 1;
        int index = 0;
        while (index < indes.size()) {
            int beforeSlipIndex = indes.get(index);
            int afterSlipInd = beforeSlipIndex + slips[beforeSlipIndex];
            int currStep = steps.get(index);
            if (afterSlipInd - jumps[afterSlipInd] < 0) {
                System.out.println(steps.get(index));
                String result = "0";
                while (prev.get(index) != -1) {
                    result = (indes.get(index) + 1) + " " + result;
                    index = prev.get(index);
                }
                System.out.println(result);
                return;
            }
            for (int k = 1; k <= jumps[afterSlipInd]; k++) {
                int nextBeforeSlipInd = afterSlipInd - k;
                if (DP[nextBeforeSlipInd] == 0 || DP[nextBeforeSlipInd] > currStep + 1) {
                    indes.add(nextBeforeSlipInd);
                    steps.add(currStep + 1);
                    prev.add(index);
                    DP[nextBeforeSlipInd] = currStep + 1;
                }
            }
            index++;
        }
        System.out.println(-1);
    }
}