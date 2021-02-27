import java.io.*;
import java.util.*;

public class CloseTuples {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        readInt(br);
        int[] ints = readArrInt(br);
        System.out.println(countNumberOfClosedTouple(ints));
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

    private static long countNumberOfClosedTouple(int[] arr) {
        long totalCount = 0;
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!numberCount.containsKey(arr[i])) {
                numberCount.put(arr[i], 0);
            }
            Integer count = numberCount.get(arr[i]);
            numberCount.put(arr[i], count + 1);
        }
        for (int key : numberCount.keySet()) {
            if (numberCount.get(key) >= 3) {
                int totalCount1 = numberCount.get(key) * (numberCount.get(key) - 1) * (numberCount.get(key) - 2);
                totalCount += totalCount1 / 6;
            }
            if (numberCount.containsKey(key + 1) && numberCount.get(key) >= 2) {
                int totalCount1 = numberCount.get(key) * (numberCount.get(key) - 1);
                int totalCount2 = numberCount.get(key + 1);
                totalCount += totalCount1 / 2 * totalCount2;
            }
            if (numberCount.containsKey(key + 1) && numberCount.get(key + 1) >= 2) {
                int totalCount1 = numberCount.get(key);
                int totalCount2 = numberCount.get(key + 1) * (numberCount.get(key + 1) - 1);
                totalCount += totalCount1 * totalCount2 / 2;
            }
            if (numberCount.containsKey(key + 2) && numberCount.get(key) >= 2) {
                int totalCount1 = numberCount.get(key) * (numberCount.get(key) - 1);
                int totalCount2 = numberCount.get(key + 2);
                totalCount += totalCount1 / 2 * totalCount2;
            }
            if (numberCount.containsKey(key + 2) && numberCount.get(key + 2) >= 2) {
                int totalCount1 = numberCount.get(key);
                int totalCount2 = numberCount.get(key + 2) * (numberCount.get(key + 2) - 1);
                totalCount += totalCount1 * totalCount2 / 2;
            }
            if (numberCount.containsKey(key + 2) && numberCount.containsKey(key + 1)) {
                totalCount += numberCount.get(key) * numberCount.get(key + 1) * numberCount.get(key + 2);
            }

        }
        return totalCount;
    }
}

