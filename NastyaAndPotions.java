import java.io.*;
import java.util.*;

public class NastyaAndPotions {
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
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<Integer>> mixtureFormula = new HashMap<>();
        for (int i = 0; i < nk[0]; i++) {
            int[] mixture = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (mixture[0] != 0) {
                ArrayList<Integer> components = new ArrayList<>();
                for (int j = 1; j < mixture.length; j++) {
                    components.add(mixture[j]);
                }
                mixtureFormula.put(i, components);
            }
        }
        evaluate(nk[0], nk[1], c, p, mixtureFormula);
    }

    private static void evaluate(int n, int k, int[] c, int[] p, Map<Integer, List<Integer>> mixtureFormula) {
        int[] minCost = new int[n];
        boolean[] foundMinCost = new boolean[n];

        // calculate minCost for available components
        calculateMinCostForAvailableComponents(foundMinCost, p);

        // calculate minCost for unavailable components
        for (int i = 0; i < n; i++) {
            int cost = calculateMinCost(i, c, minCost, foundMinCost, mixtureFormula);
            System.out.print(cost + " ");
        }
        System.out.println();
    }

    private static int calculateMinCost(int index, int[] cost, int[] minCost, boolean[] foundMinCost, Map<Integer, List<Integer>> mixtureFormula) {
        if (foundMinCost[index]) {
            return minCost[index];
        }
        if (!mixtureFormula.containsKey(index)) {
            minCost[index] = cost[index];
            foundMinCost[index] = true;
            return minCost[index];
        }
        int costWithoutMixing = cost[index];
        int costOfAllComponents = 0;

        List<Integer> requiredComponents = mixtureFormula.get(index);
        for (int component : requiredComponents) {
            component--;
            // System.out.println("[" + index + "] -> calculation of component:" + +component);
            costOfAllComponents += calculateMinCost(component, cost, minCost, foundMinCost, mixtureFormula);
            if (costWithoutMixing < costOfAllComponents) {
                break;
            }
        }
        minCost[index] = Math.min(costWithoutMixing, costOfAllComponents);
        foundMinCost[index] = true;
        return minCost[index];
    }

    private static void calculateMinCostForAvailableComponents(boolean[] foundMinCost, int[] p) {
        for (int pi : p) {
            foundMinCost[pi - 1] = true;
        }
    }
}