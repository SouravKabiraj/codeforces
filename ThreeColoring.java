import java.io.*;
import java.util.*;

public class ThreeColoring {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        play(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        print(readArrInt(br));
        System.out.println(readList(br));
        int[][] ar = new int[][]{{1, 2}, {1, 2}};
        print(ar);
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

    private static void play(BufferedReader br) throws Exception {
        int n = readInt(br);
        TreeSet<ThreeColoringCell> black = new TreeSet<>();
        TreeSet<ThreeColoringCell> white = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    black.add(new ThreeColoringCell(i, j));
                } else {
                    white.add(new ThreeColoringCell(i, j));
                }
            }
        }

        for (int i = 0; i < n * n; i++) {
            int input = readInt(br);
            switch (input) {
                case 1:
                    if (!black.isEmpty()) {
                        ThreeColoringCell cell = black.first();
                        black.remove(cell);
                        System.out.println("2 " + (cell.i + 1) + " " + (cell.j + 1));
                    } else {
                        ThreeColoringCell cell = white.first();
                        white.remove(cell);
                        System.out.println("3 " + (cell.i + 1) + " " + (cell.j + 1));
                    }
                    break;
                case 2:
                    if (!white.isEmpty()) {
                        ThreeColoringCell cell = white.first();
                        white.remove(cell);
                        System.out.println("1 " + (cell.i + 1) + " " + (cell.j + 1));
                    } else {
                        ThreeColoringCell cell = black.first();
                        black.remove(cell);
                        System.out.println("3 " + (cell.i + 1) + " " + (cell.j + 1));
                    }
                    break;
                case 3:
                    if (!white.isEmpty()) {
                        ThreeColoringCell cell = white.first();
                        white.remove(cell);
                        System.out.println("1 " + (cell.i + 1) + " " + (cell.j + 1));
                    } else {
                        ThreeColoringCell cell = black.first();
                        black.remove(cell);
                        System.out.println("2 " + (cell.i + 1) + " " + (cell.j + 1));
                    }
                    break;
            }
        }
    }
}

class ThreeColoringCell implements Comparable<ThreeColoringCell> {
    int i;
    int j;
    int priority;

    ThreeColoringCell(int i, int j) {
        this.i = i;
        this.j = j;
        this.priority = 3;
    }

    @Override
    public int hashCode() {
        String str = i + " " + j;
        return str.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ThreeColoringCell otherCell = (ThreeColoringCell) obj;
        return i == otherCell.i && j == otherCell.j;
    }

    @Override
    public int compareTo(ThreeColoringCell o) {
        int diff = priority - o.priority;
        if (diff == 0) {
            int xDiff = i - o.i;
            if (xDiff == 0) {
                return j - o.j;
            }
            return xDiff;
        }
        return diff;
    }

    @Override
    public String toString() {
        return "i=" + i + ",j=" + j + ",priority=" + priority;
    }
}

class ThreeColoringPointers {
    ThreeColoringCell q1;
    ThreeColoringCell q2;
    ThreeColoringCell q3;

    public ThreeColoringPointers(ThreeColoringCell q1, ThreeColoringCell q2, ThreeColoringCell q3) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }
}

