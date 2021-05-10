import java.io.*;
import java.util.*;

public class SwapLetters {
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
        readInt(br);
        String line1 = br.readLine();
        String line2 = br.readLine();
        List<Integer> p = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        for (int i = 0; i < line1.length(); i++) {
            if (line2.charAt(i) == 'a' && line1.charAt(i) == 'b') {
                p.add(i);
            }

            if (line2.charAt(i) == 'b' && line1.charAt(i) == 'a') {
                n.add(i);
            }
        }
        getSwipsList(p, n);
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

    private static void getSwipsList(List<Integer> positives, List<Integer> negatives) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int excessPositive = -1;
        int excessNegative = -1;
        for (int i = 0; i < positives.size(); i = i + 2) {
            if (i == positives.size() - 1) {
                excessPositive = positives.get(i);
                break;
            }
            int currInd = positives.get(i);
            int nextIndex = positives.get(i + 1);
            list1.add(currInd);
            list2.add(nextIndex);
        }

        for (int i = 0; i < negatives.size(); i = i + 2) {
            if (i == negatives.size() - 1) {
                excessNegative = negatives.get(i);
                break;
            }
            int currInd = negatives.get(i);
            int nextIndex = negatives.get(i + 1);
            list1.add(currInd);
            list2.add(nextIndex);
        }

        if (excessPositive == -1 && excessNegative == -1) {
            System.out.println(list1.size());
            for (int i = 0; i < list1.size(); i++) {
                System.out.println((list1.get(i) + 1) + " " + (list2.get(i) + 1));
            }
        } else if (excessPositive == -1 || excessNegative == -1) {
            System.out.println("-1");
        } else {
            System.out.println(list1.size() + 2);
            for (int i = 0; i < list1.size(); i++) {
                System.out.println((list1.get(i) + 1) + " " + (list2.get(i) + 1));
            }
            System.out.println((excessPositive + 1) + " " + (excessPositive + 1));
            System.out.println((excessPositive + 1) + " " + (excessNegative + 1));
        }
    }
}

