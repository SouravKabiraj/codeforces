import java.io.*;
import java.util.*;

public class RobotBreakout {
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
        int n = readInt(br);
        List<Robot> robots = new ArrayList<>();
        List<Cell> initialCells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] xySteps = readArrInt(br);
            int x = xySteps[0];
            int y = xySteps[1];
            boolean left = xySteps[2] == 1;
            boolean down = xySteps[3] == 1;
            boolean right = xySteps[4] == 1;
            boolean up = xySteps[5] == 1;
            robots.add(new Robot(up, down, left, right));
            initialCells.add(new Cell(x, y));
        }
        getFirstMeetPoint(robots, initialCells);
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

    private static void getFirstMeetPoint(List<Robot> robots, List<Cell> initialPos) {
        int maxX = 100000;
        int maxY = 100000;
        int minX = -100000;
        int minY = -100000;

        for (int i = 0; i < robots.size(); i++) {
            Robot robo = robots.get(i);
            Cell cell = initialPos.get(i);
            if (!robo.right) maxX = Math.min(maxX, cell.x);
            if (!robo.left) minX = Math.max(minX, cell.x);
            if (!robo.up) maxY = Math.min(maxY, cell.y);
            if (!robo.down) minY = Math.max(minY, cell.y);

            // print(new int[]{minX, minY, maxX, maxY});
        }
        if (minX <= maxX && minY <= maxY) {
            System.out.println("1 " + minX + " " + minY);
        } else {
            System.out.println("0");
        }
    }
}

class Robot {
    boolean up;
    boolean down;
    boolean left;
    boolean right;

    public Robot(boolean up, boolean down, boolean left, boolean right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public List<Cell> getNextSteps(Cell cell) {
        List<Cell> nexts = new ArrayList<>();
        if (up && cell.y + 1 != 200000) {
            nexts.add(new Cell(cell.x, cell.y + 1));
        }
        if (down && cell.y != 0) {
            nexts.add(new Cell(cell.x, cell.y - 1));
        }
        if (left && cell.x != 0) {
            nexts.add(new Cell(cell.x - 1, cell.y));
        }
        if (right && cell.x + 1 != 200000) {
            nexts.add(new Cell(cell.x + 1, cell.y));
        }
        return nexts;
    }
}

class Cell {
    int x;
    int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Cell other = (Cell) obj;
        if (other.x == x && other.y == y) {
            return true;
        }
        return false;
    }
}
