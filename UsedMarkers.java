import java.io.*;
import java.util.*;

public class UsedMarkers {
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
        int[] a = readArrInt(br);
        printOrder(a);
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

    private static void printOrder(int[] arr) {
        String out = "";
        TreeMap<Integer, List<Integer>> userIndex = new TreeMap<>();
        int used = 0;
        for (int i = 0; i < arr.length; i++) {
            used = Math.max(used, arr[i]);
            if (!userIndex.containsKey(arr[i])) {
                userIndex.put(arr[i], new ArrayList<>());
            }
            List<Integer> tempList = userIndex.get(arr[i]);
            tempList.add(i);
        }
        NavigableSet<Integer> keys = userIndex.descendingKeySet();
        Iterator<Integer> iterator;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            iterator = keys.iterator();
            while (iterator.hasNext()) {
                int curr = iterator.next();
                if (curr <= used) {
                    used = 1;
                    out = out + (userIndex.get(curr).get(0) + 1) + " ";
                    userIndex.get(curr).remove(0);
                    if (userIndex.get(curr).size() == 0) {
                        keys.remove(curr);
                    }
                    flag = true;
                    break;
                }
            }
            iterator = keys.iterator();
            if (!flag && iterator.hasNext()) {
                int curr = iterator.next();
                used++;
                out = out + (userIndex.get(curr).get(0) + 1) + " ";
                userIndex.get(curr).remove(0);
                if (userIndex.get(curr).size() == 0) {
                    iterator.remove();
                }
            }
        }
        System.out.println(out.substring(0, out.length() - 1));
    }
}

