import java.io.*;
import java.util.*;

public class  EqualizeTheArray {
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
	int[] arr = readArrInt(br);
	System.out.println(minRemove(arr));
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


    private static int minRemove(int[] arr) {
        int totalCount = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        Map<Integer, Integer> countNums = new TreeMap<>();
        for (int item : arr) {
            if (!numCount.containsKey(item)) {
                numCount.put(item, 0);
            }
            Integer count = numCount.get(item);
            numCount.put(item, count + 1);
        }

        for (int key : numCount.keySet()) {
            int count = numCount.get(key);
            if (!countNums.containsKey(count)) {
                countNums.put(count, 0);
            }
            int nums = countNums.get(count);
            countNums.put(count, nums + 1);
        }

        int result = arr.length;
        int distNumCount = numCount.keySet().size();
        int distCountTillNow = 0;
        for (int key : countNums.keySet()) {
            // if we consider key is the number = c
            int remainCount = (distNumCount - distCountTillNow) * key;
            result = Math.min(result, arr.length - remainCount);
            distCountTillNow = distCountTillNow + countNums.get(key);
        }
        return result;
    }
}

