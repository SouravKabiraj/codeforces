import java.io.*;
import java.util.*;

public class WorkoutPlan {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTestCase(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        int[] N_BASE = readArrInt(br);
        int[] Gyms = readArrInt(br);
        int powerUp = readInt(br);
        int[] costs = readArrInt(br);
        System.out.println(getTotalCost(N_BASE[1], powerUp, Gyms, costs));
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

    private static List<Integer> readList(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
        return arr;
    }

    private static void print(int[][] mat) {
        System.out.println("----------------------------------------");
        for (int i = 0; i < mat.length; i++) {
            System.out.print("{");
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println("----------------------------------------");
    }

    private static void print(int[] mat) {
        System.out.print("{");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println("}");
    }

    private static long getTotalCost(int baseStrength, int powerUp, int[] gyms, int[] costs) {
        long totalCost = 0;
        int shakeCount = 0;
        int[] powerNeeds = new int[gyms.length];
        TreeMap<Integer, Integer> costCount = new TreeMap<>();
        int lastPower = 0;
        for (int i = 0; i < gyms.length; i++) {
            shakeCount++;
            powerNeeds[i] = (int) Math.ceil(((double) gyms[i] - (double) baseStrength) / powerUp);
            if (!costCount.containsKey(costs[i]))
                costCount.put(costs[i], 0);
            costCount.put(costs[i], costCount.get(costs[i]) + 1);
            if (powerNeeds[i] - lastPower > shakeCount) {
                return -1;
            }
            while (powerNeeds[i] - lastPower > 0) {
                int pickedCost = costCount.firstKey();
                if (costCount.get(pickedCost) == 1) {
                    costCount.remove(pickedCost);
                    totalCost = totalCost + pickedCost;
                    lastPower++;
                    shakeCount--;
                } else {
                    costCount.put(pickedCost, costCount.get(pickedCost) - 1);
                    totalCost = totalCost + pickedCost;
                    lastPower++;
                    shakeCount--;
                }
            }
        }
        return totalCost;
    }
}

