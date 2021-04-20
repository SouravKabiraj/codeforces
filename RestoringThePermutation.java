import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class RestoringThePermutation {
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
        int[] inps = readArrInt(br);
        printMaxAndMinLex(inps);
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
        for (int i = 0; i < mat.length; i++) {
            if (i < mat.length - 1)
                System.out.print(mat[i] + " ");
            else
                System.out.print(mat[i]);
        }
        System.out.println();
    }

    private static void printMaxAndMinLex(int[] arr) {
        Set<Integer> availableNums = new TreeSet<>();
        Set<Integer> availableMaxNums = new TreeSet<>();
        List<Integer> filledIndex = new ArrayList<>();
        int[] minLex = new int[arr.length];
        int[] maxLex = new int[arr.length];
        minLex[0] = arr[0];
        maxLex[0] = arr[0];
        filledIndex.add(0);
        for (int i = 1; i <= arr.length; i++) {
            availableNums.add(i);
            availableMaxNums.add(i);
        }
        availableNums.remove(arr[0]);
        availableMaxNums.remove(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                minLex[i] = arr[i];
                maxLex[i] = arr[i];
                availableNums.remove(arr[i]);
                availableMaxNums.remove(arr[i]);
                filledIndex.add(i);
            }
        }
        Iterator itr = availableNums.iterator();
        for (int i = 0; i < arr.length; i++) {
            if (minLex[i] == 0) {
                minLex[i] = (int) itr.next();
            }
        }

        for (int i = 0; i < filledIndex.size(); i++) {
            int firstFilledIndex = filledIndex.get(i);
            int firstFilledNum = arr[firstFilledIndex];
            int nextFilledIndex = i + 1 == filledIndex.size() ? arr.length : filledIndex.get(i + 1);
            int num = firstFilledNum - 1;
            for (int j = firstFilledIndex + 1; j < nextFilledIndex; j++) {
                while (!availableMaxNums.contains(num)) {
                    num--;
                }
                maxLex[j] = num;
                availableMaxNums.remove(num);
                num--;
            }
        }

        print(minLex);
        print(maxLex);
    }
}

