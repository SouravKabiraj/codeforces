import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DiscreteAcceleration {
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
        int[] nEnd = readArrInt(br);
        int end = nEnd[1];
        int[] flags = readArrInt(br);
        getMeetTime(flags, end);
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

    private static void getMeetTime(int[] flag, int endPoint) {
        double ans = 0;
        int i = 0;
        int j = flag.length - 1;
        double positionA = 0;
        double positionB = endPoint;
        double sA = 1;
        double sB = 1;
        while (i <= j) {
            double distA = flag[i] - positionA;
            double distB = positionB - flag[j];
            double timeA = distA * 1.0 / sA;
            double timeB = distB * 1.0 / sB;
            if (timeA <= timeB) {
                ans = ans + timeA;
                positionA = positionA + distA;
                positionB = positionB - timeA * sB * 1.0;
                sA++;
                i++;
            } else {
                ans = ans + timeB;
                positionB = positionB - distB;
                positionA = positionA + timeB * sA * 1.0;
                sB++;
                j--;
            }
        }
        double posDiff = positionB - positionA;
        double s = sA + sB;
        ans = (ans + posDiff / s);
        System.out.printf("%.15f\n", ans);
    }
}

