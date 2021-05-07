import java.io.*;
import java.util.*;

public class KAmazingNumbers {
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
        showKAmazingNumbers(ints);
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

    private static void showKAmazingNumbers(int[] arr) {
        HashMap<Integer, List<Integer>> numIndex = new HashMap<>();
        int[] result = new int[arr.length + 1];
        Arrays.fill(result, -1);
        for (int i = 0; i < arr.length; i++) {
            if (!numIndex.containsKey(arr[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(-1);
                numIndex.put(arr[i], list);
            }
            List<Integer> l = numIndex.get(arr[i]);
            l.add(i);
            numIndex.put(arr[i], l);
        }

        for (Map.Entry<Integer, List<Integer>> entry : numIndex.entrySet()) {
            List<Integer> indexs = entry.getValue();
            indexs.add(arr.length);
            int lastInd = -1;
            int max = 0;
            for (int ele : indexs) {
                max = Math.max(ele - lastInd, max);
                lastInd = ele;
            }
            result[max] = result[max] == -1 ? entry.getKey() : Math.min(result[max], entry.getKey());
        }

        String res = "";
        for (int i = 1; i <= arr.length; i++) {
            result[i] = result[i] == -1 ? result[i - 1] : result[i];
            if (result[i - 1] != -1 && result[i - 1] < result[i]) {
                result[i] = result[i - 1];
            }
            res = res + result[i] + " ";
        }
        System.out.println(res);
    }
}

