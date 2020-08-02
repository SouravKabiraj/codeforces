import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ModuloEquality {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = readArrInt(br);
	int M = NM[1];
	HashMap<Integer,Integer> Acount= readCount(br,M);
        HashMap<Integer,Integer> Bcount= readCount(br,M);
	// System.out.println(Acount);
        // System.out.println(Bcount);
	System.out.println(getMinShift(Bcount,Acount,M));
    }

    private static HashMap<Integer,Integer> readCount(BufferedReader br, int M) throws Exception {
    	HashMap<Integer,Integer> map = new HashMap<>();
	String[] inputs = br.readLine().split(" ");
	for(int i = 0; i<inputs.length; i++) {
		int element = Integer.parseInt(inputs[i]);
		if(!map.containsKey(element)){
			map.put(element,1);
		}else {
			map.put(element,map.get(element)+1);
		}
		
	}
	return map;
    }

    private static int getMinShift(HashMap<Integer,Integer> A, HashMap<Integer,Integer> B, int M) {
    	for (int i = 0; i < M; i++) {
            int count = 0;

            while (count < M) {
                if (B.containsKey(count) && (!A.containsKey((i + count) % M) || B.get(count) != A.get((i + count) % M))) {
                    break;
                }
                count++;
            }

            if (count == M) {
                return i;
            }
        }
        return -1;
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

