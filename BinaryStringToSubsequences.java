import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryStringToSubsequences {
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
        br.readLine();
        String str = br.readLine();
        printSequence(str);
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

    private static void printSequence(String arr) {
        List<Integer> lastZeroSeq = new ArrayList<>();
        List<Integer> lastOneSeq = new ArrayList<>();
        int order = 0;
        String resultStr = "";
        int[] result = new int[arr.length()];
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == '1') {
                if (lastZeroSeq.size() == 0) {
                    order++;
                    result[i] = order;
                } else {
                    int seqNumber = lastZeroSeq.get(lastZeroSeq.size() - 1);
                    result[i] = result[seqNumber];
                    lastZeroSeq.remove(lastZeroSeq.size() - 1);
                }
                lastOneSeq.add(i);
            } else {
                if (lastOneSeq.size() == 0) {
                    order++;
                    result[i] = order;
                } else {
                    int seqNumber = lastOneSeq.get(lastOneSeq.size() - 1);
                    result[i] = result[seqNumber];
                    lastOneSeq.remove(lastOneSeq.size() - 1);
                }
                lastZeroSeq.add(i);
            }
            resultStr = resultStr + result[i] + " ";
        }
        System.out.println(order);
        System.out.println(resultStr);
    }
}

