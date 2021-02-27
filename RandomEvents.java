import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RandomEvents {
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
        int[] inpLine = readArrInt(br);
	int N = inpLine[0];
	int M = inpLine[1];
	int[] arr = readArrInt(br);
	double[][] ran = new double[M][2];
	for(int i=0; i<M; i++) {
		ran[i] = readArrDouble(br);
	}
	getProbability(arr,ran);
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

    private static double[] readArrDouble(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        double[] arr = new double[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Double.parseDouble(line[i]);
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

    private static void getProbability(int[] arr, double[][] ranges) {
    	int n= arr.length;
	int M = arr.length;
	double revP = 1;
	boolean flag = false;

	for(int i=arr.length-1; i>=0; i--) {
		if(arr[i]!=i+1) {
			M = i+1;
			flag = true;
			break;
		}
	}
	if(!flag) {
		System.out.println("1.000000");
	}else {

	for(int i=0; i<ranges.length; i++) {
		if((int)ranges[i][0]>=M) {
			revP = revP * (1-ranges[i][1]);
		}
	}
	System.out.print(String.format("%.6g%n", (1-revP)));
	}
    }
}

