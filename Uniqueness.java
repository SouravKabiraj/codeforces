import java.io.*;
import java.util.*;

public class Uniqueness {
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
        br.readLine();
        int[] arr = readArrInt(br);
        System.out.println(getSize(arr));
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

    private static int getSize(int[] arr) {
        // print(arr);
        Set<Integer> s1 = new HashSet<>();
        HashMap<Integer, Integer> extrasCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!s1.contains(arr[i])) {
                s1.add(arr[i]);
            } else {
                if (!extrasCount.containsKey(arr[i])) {
                    extrasCount.put(arr[i], 0);
                }
                extrasCount.put(arr[i], extrasCount.get(arr[i]) + 1);
            }
        }
        int extraSize = arr.length - s1.size();
        if (extraSize == 0) {
            return 0;
        }
        HashMap<Integer, Integer> extrasCountCheck = new HashMap<>();
        for (int len = extraSize; len < arr.length; len++) {
            for (int i = 0; i < arr.length; i++) {
                // System.out.println(i);
                if (extrasCount.containsKey(arr[i])) {
                    if (!extrasCountCheck.containsKey(arr[i])) {
                        extrasCountCheck.put(arr[i], 0);
                    }
                    extrasCountCheck.put(arr[i], extrasCountCheck.get(arr[i]) + 1);
                }

                if (i - len >= 0) {
                    if (extrasCount.containsKey(arr[i - len])) {
                        extrasCountCheck.put(arr[i - len], extrasCountCheck.get(arr[i - len]) - 1);
                        if (extrasCountCheck.get(arr[i - len]) == 0) {
                            extrasCountCheck.remove(arr[i - len]);
                        }
                    }
                }
                // System.out.println(extrasCountCheck);
                if (extrasCountCheck.equals(extrasCount)) {
                    return len;
                }
            }
        }
        return arr.length;
    }
}

