import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class RemoveOneElement {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
	int[] A = readArrInt(br);
	System.out.println(getSizeOfContogiousSubArray(A));
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }


    private static int getSizeOfContogiousSubArray(int[] A) {
    	if (A.length == 0) return 0;
        int[] C = new int[A.length];
        int maxLn = 1;
        C[0] = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                C[i] = C[i - 1] + 1;
            } else {
                C[i] = 1;
            }
            maxLn = Math.max(maxLn, C[i]);
        }
        Set<Integer> joint = new HashSet<>();
        for (int i = 1; i < A.length - 1; i++) {
            // System.out.println(A[i - 1] + " " + A[i] + " " + A[i + 1]);
            if ((A[i] - A[i - 1]) > (A[i] - A[i + 1]) && (A[i + 1] - A[i]) <= 0) {
                joint.add(i);
            }
            if ((A[i] - A[i - 1]) > (A[i] - A[i + 1]) && A[i] - A[i - 1] <= 0) {
                joint.add(i);
            }
        }

        for (int index : joint) {
            int len = C[index - 1] + 1;
            for (int i = index + 2; i < A.length && A[i - 1] < A[i]; i++) {
                len = len + 1;
            }
            maxLn = Math.max(maxLn, len);
        }

        return maxLn;
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
}

