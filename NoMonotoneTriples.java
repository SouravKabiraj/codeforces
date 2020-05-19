import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class NoMonotoneTriples {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NQ = readArrInt(br);
        int[] A = readArrInt(br);
        for (int tc = 0; tc < NQ[1]; tc++) {
            int[] startEnd = readArrInt(br);
            int start = startEnd[0] - 1;
            int end = startEnd[1] - 1;
            getMaxArr(A, start, end);
        }
    }

    private static void getMaxArr(int[] A, int start, int end) {
        int startMax = start;
        int endMax = start;
        int init = start;

        for (int prevPointer = init; prevPointer + 2 <= end; prevPointer++) {
            int pointer = prevPointer + 1;
            int nextPointer = pointer + 1;
            if (A[prevPointer] == A[pointer]) {
                if ((endMax - startMax) < (pointer - init)) {
                    startMax = init;
                    endMax = pointer;
                }
                init = pointer;
            } else if (A[pointer] == A[nextPointer]) {
                if ((endMax - startMax) < (pointer - init)) {
                    startMax = init;
                    endMax = pointer;
                }
                init = pointer;
            } else if (A[prevPointer] <= A[pointer] && A[pointer] <= A[nextPointer]) {
                if ((endMax - startMax) < (pointer - init)) {
                    startMax = init;
                    endMax = pointer;
                }
                init = pointer;
            } else if (A[prevPointer] >= A[pointer] && A[pointer] >= A[nextPointer]) {
                if ((endMax - startMax) < (pointer - init)) {
                    startMax = init;
                    endMax = pointer;
                }
                init = pointer;
            } else if (nextPointer == end) {
                if ((endMax - startMax) < (nextPointer - init)) {
                    startMax = init;
                    endMax = nextPointer;
                }
            }
        }

	if(endMax-startMax>1){
		System.out.println(endMax-startMax+1);
		for(int i=startMax+1;i<=endMax+1;i++){
			System.out.print(i+ " ");
		}
        	System.out.println();
	}else {
		System.out.println(0);
	}

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
}

