import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pipes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
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
        br.readLine();
        String line1 = br.readLine();
        String line2 = br.readLine();
        int[][] pipes = new int[2][line1.length()];
        for (int i = 0; i < line1.length(); i++) {
            pipes[0][i] = line1.charAt(i) - '0';
            pipes[1][i] = line2.charAt(i) - '0';
        }
        if (isFlowPossible(pipes)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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

    private static boolean isFlowPossible(int[][] pipes) {
        int x = pipes[0].length - 1;
        int y = 1;
        return isPathAvailable(pipes, y, x);
    }

    private static boolean isPathAvailable(int[][] pipes, int x, int y) {
        if (y >= 2 || y < 0) {
            return false;
        }
        if (x < 0 || x >= pipes[0].length) {
            return false;
        }
        if (y == 0 && x == 0) {
            return true;
        }

        int currentPipe = pipes[x][y];
        List<Integer> nextCell = nextXY(currentPipe, x, y);
        int nextX = nextCell.get(0);
        int nextY = nextCell.get(1);
        return nextPipe(currentPipe).stream().anyMatch(m -> {
            int nextPipe = pipes[nextX][nextY];
            if (!isConversionPossible(nextPipe, m))
                return false;
            pipes[nextX][nextY] = m;
            boolean pathAvailable = isPathAvailable(pipes, nextX, nextY);
            pipes[nextX][nextY] = nextPipe;
            return pathAvailable;
        });
    }

    private static boolean isConversionPossible(int nextPipe, Integer m) {
        if (nextPipe == m) return true;
        if (nextPipe == 1 && m == 2 || nextPipe == 2 && m == 1) {
            return true;
        }
        if (2 < nextPipe && nextPipe < 7 && 2 < m && m < 7) {
            return true;
        }
        return false;
    }

    private static List<Integer> nextPipe(int pipe) {
        switch (pipe) {
            case 2:
                return Arrays.asList(3, 6);
            case 3:
                return Arrays.asList(5);
            case 4:
            case 5:
                return Arrays.asList(3, 6, 2);
            case 6:
                return Arrays.asList(4);
        }
        return Collections.emptyList();
    }

    private static List<Integer> nextXY(int pipe, int x, int y) {
        switch (pipe) {
            case 2:
                return Arrays.asList(x - 1, y);
            case 3:
                return Arrays.asList(x, y + 1);
            case 4:
            case 5:
                return Arrays.asList(x + 1, y);
            case 6:
                return Arrays.asList(x, y - 1);
        }
        return Arrays.asList(x, y);
    }
}

/*
   |      ____         ____     ____
   |                  |            |       ____|      |_____
   1       2          3            4         5          6

   2 -> 3   (x-1, y)
   2 -> 6   (x-1, y)

   3 -> 5   (x, y+1)

   4 -> 3   (x+1, y)
   4 -> 6   (x+1, y)
   4 -> 2   (x+1, y)

   5 -> 2   (x+1, y)
   5 -> 3   (x+1, y)
   5 -> 6   (x+1, y)

   6 -> 4   (x, y-1)
 */