import java.io.*;
import java.util.*;

public class BinaryTable {
    private static int[][] mat;
    private static String opsString = "";
    private static int opCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        int[] mn = readArrInt(br);
        int m = mn[0];
        int n = mn[1];
        mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            mat[i] = readBin(br);
        }
        operate(mat);
        System.out.println(opCount);
        System.out.print(opsString);
        print(mat);
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

    private static int[] readBin(BufferedReader br) throws Exception {
        String line = br.readLine();
        int[] arr = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i) == '1' ? 1 : 0;
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

    private static void operate(int[][] mat) {
        for (int i = 0; i < (mat.length / 2) * 2; i = i + 2) {
            for (int j = 0; j < (mat[0].length / 2) * 2; j = j + 2) {
                printOperations(mat, i, j);
            }
        }
        if (mat.length % 2 == 1) {
            for (int i = 0; i < (mat[0].length / 2) * 2; i = i + 2) {
                printOperations(mat, mat.length - 2, i);
            }
        }

        if (mat[0].length % 2 == 1) {
            for (int i = 0; i < (mat.length / 2) * 2; i = i + 2) {
                printOperations(mat, i, mat[0].length - 2);
            }
        }

        if (mat.length % 2 == 1 && mat[0].length % 2 == 1) {
            printOperations(mat, mat.length - 2, mat[0].length - 2);
        }
    }

    private static void printOperations(int[][] mat, int x, int y) {
        Map<Integer, int[]> seq = new HashMap<>();
        int start = 0;
        int end = 5;
        if (mat[x][y] == 1) {
            start++;
            seq.put(start, new int[]{x, y});
        } else {
            end--;
            seq.put(end, new int[]{x, y});
        }
        if (mat[x][y + 1] == 1) {
            start++;
            seq.put(start, new int[]{x, y + 1});
        } else {
            end--;
            seq.put(end, new int[]{x, y + 1});
        }
        if (mat[x + 1][y] == 1) {
            start++;
            seq.put(start, new int[]{x + 1, y});
        } else {
            end--;
            seq.put(end, new int[]{x + 1, y});
        }
        if (mat[x + 1][y + 1] == 1) {
            start++;
            seq.put(start, new int[]{x + 1, y + 1});
        } else {
            end--;
            seq.put(end, new int[]{x + 1, y + 1});
        }
        switch (start) {
            case 1:
                printFor1Ones(seq);
                break;
            case 2:
                printFor2Ones(seq);
                break;
            case 3:
                printFor3Ones(seq);
                break;
            case 4:
                printFor4Ones(seq);
                break;
            default:
        }
    }

    private static void printFor1Ones(Map<Integer, int[]> seq) {
        opCount++;
        alt(seq.get(1));
        alt(seq.get(2));
        alt(seq.get(3));
        opsString = opsString + ((seq.get(1)[0] + 1) + " " + (seq.get(1)[1] + 1) + " " + (seq.get(2)[0] + 1) + " " + (seq.get(2)[1] + 1) + " " + (seq.get(3)[0] + 1) + " " + (seq.get(3)[1] + 1) + "\n");
        Map<Integer, int[]> newSeq = new HashMap<>();
        newSeq.put(1, seq.get(2));
        newSeq.put(2, seq.get(3));
        newSeq.put(3, seq.get(1));
        newSeq.put(4, seq.get(4));
        printFor2Ones(newSeq);
    }

    private static void printFor2Ones(Map<Integer, int[]> seq) {
        opCount++;
        alt(seq.get(2));
        alt(seq.get(3));
        alt(seq.get(4));
        opsString = opsString + ((seq.get(2)[0] + 1) + " " + (seq.get(2)[1] + 1) + " " + (seq.get(3)[0] + 1) + " " + (seq.get(3)[1] + 1) + " " + (seq.get(4)[0] + 1) + " " + (seq.get(4)[1] + 1) + "\n");
        Map<Integer, int[]> newSeq = new HashMap<>();
        newSeq.put(1, seq.get(1));
        newSeq.put(2, seq.get(3));
        newSeq.put(3, seq.get(4));
        newSeq.put(4, seq.get(2));
        printFor3Ones(newSeq);
    }

    private static void printFor3Ones(Map<Integer, int[]> seq) {
        opCount++;
        alt(seq.get(1));
        alt(seq.get(2));
        alt(seq.get(3));
        opsString = opsString + ((seq.get(1)[0] + 1) + " " + (seq.get(1)[1] + 1) + " " + (seq.get(2)[0] + 1) + " " + (seq.get(2)[1] + 1) + " " + (seq.get(3)[0] + 1) + " " + (seq.get(3)[1] + 1) + "\n");
    }

    private static void printFor4Ones(Map<Integer, int[]> seq) {
        opCount++;
        alt(seq.get(2));
        alt(seq.get(3));
        alt(seq.get(4));
        opsString = opsString + ((seq.get(2)[0] + 1) + " " + (seq.get(2)[1] + 1) + " " + (seq.get(3)[0] + 1) + " " + (seq.get(3)[1] + 1) + " " + (seq.get(4)[0] + 1) + " " + (seq.get(4)[1] + 1) + "\n");
        Map<Integer, int[]> newSeq = new HashMap<>();
        newSeq.put(1, seq.get(1));
        newSeq.put(2, seq.get(2));
        newSeq.put(3, seq.get(3));
        newSeq.put(4, seq.get(4));
        printFor1Ones(newSeq);
    }

    private static void alt(int[] a) {
        int x = a[0];
        int y = a[1];
        mat[x][y] = mat[x][y] == 1 ? 0 : 1;
    }
}

