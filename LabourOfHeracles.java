import java.io.*;
import java.util.*;

public class LabourOfHeracles {

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
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
        int[] arrInt = readArrInt(br);
        getSumOfKColoring(arrInt, br);
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

    private static void getSumOfKColoring(int[] wg, BufferedReader br) throws Exception {
        int[] result = new int[wg.length - 1];
        int[] deg = new int[wg.length];
        Set<Pair> q = new TreeSet<>();
        Set<Pair> qs = new TreeSet<>();
        for (int i = 0; i < wg.length - 1; i++) {
            int[] arrInt = readArrInt(br);
            deg[arrInt[0] - 1]++;
            deg[arrInt[1] - 1]++;
        }
        int sum = 0;
        for (int i = 0; i < wg.length; i++) {
            sum += wg[i];
            deg[i]--;
            if (deg[i] != 0) {
                q.add(new Pair(i, wg[i]));
            }
        }
        int i = 0;
        result[i] = sum;
        System.out.print(result[0] + " ");
        Iterator<Pair> iterator = q.iterator();
        for (i = 1; i < wg.length - 1; i++) {
            if (!iterator.hasNext()) {
                break;
            }
            Pair removed = iterator.next();
            while (deg[removed.index] > 0) {
                result[i] = result[i - 1] + removed.wg;
                if (i < wg.length - 2)
                    System.out.print(result[i] + " ");
                else
                    System.out.print(result[i]);
                deg[removed.index]--;
                i++;
            }
            if (deg[removed.index] == 0) {
                i--;
            }
        }
        System.out.println();
    }

}

class Pair implements Comparable<Pair> {
    int index;
    int wg;

    public Pair(int index, int wg) {
        this.index = index;
        this.wg = wg;
    }

    public int compareTo(Pair st) {
        if (wg == st.wg)
            return 0;
        else if (wg > st.wg)
            return -1;
        else
            return 1;
    }

}
