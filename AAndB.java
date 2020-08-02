import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AAndB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }


    private static int getMinOps(int A, int B) {
    	List<int[]> Q = new ArrayList<>();
	Q.add(new int[]{A,B,initOp});
	int pointer = 0;
	while(Q.get(pointer)[0]!=Q.get(pointer)[1]) {
		int a = Q.get(pointer)[0];
		int b = Q.get(pointer)[1];
		int op = Q.get(pointer)[2];
		Q.add(new int[]{a+op+1,b,op+1});
		Q.add(new int[]{a,b+op+1,op+1});
		System.out.println("a:b:op"+a+":"+b+":"+op);
		pointer++;
	}
 
	return Q.get(pointer)[2];
    }


    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
	// System.out.println(T);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        int[] AB = readArrInt(br);
	// System.out.print(AB[0]+" - "+AB[1]+"-->");
        System.out.println(getMinOps(AB[0],AB[1]));
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

