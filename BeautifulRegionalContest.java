import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BeautifulRegionalContest {
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
        int N = Integer.parseInt(br.readLine());
	int[] A = readArrInt(br);
	int[] GSB = getPrizeList(A,N);
	System.out.println(GSB[0]+" "+GSB[1]+" "+GSB[2]);
    }

    private static int[] getPrizeList(int[] A, int N) {
	int point = 1;
        int g = 0;
        int s = 0;
        int b = 0;
        while (point <= N / 2) {
            if (A[point] != A[point - 1]) {
                if (g == 0) {
                    g = point;
                } else if (s == 0 && g < (point - g)) {
                    s = point;
                } else if (s!=0 && g < (point - s)) {
                    b = point;
                }
            }
            point++;
        }

        if (g != 0 && s != 0 && b != 0) {
            return new int[]{g, s - g, b - s};
        } else {
            return new int[]{0, 0, 0};
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
}

