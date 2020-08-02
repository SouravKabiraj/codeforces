import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class FightWithMonsters {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NABK = readArrInt(br);
	int N= NABK[0];
	int A = NABK[1];
	int B = NABK[2];
	int K = NABK[3];
	int[] Arr = readHealthPoints(br,A,B);
	System.out.println(getMaxScore(Arr,A,B,K));
    }

    private static int getMaxScore(int[] HP, int A, int B, int K) {
    	ArrayList<Integer> use = new ArrayList<Integer>();
	
	// print(HP);
	for(int i=0; i<HP.length; i++) {
		if(HP[i]<=A) {
			use.add(0);
		}else {
			use.add((int)Math.ceil((float)(HP[i]-A)/(float)A));
		}
	}

	Collections.sort(use);

	int score = 0;
	int pointer = 0; 

	while(pointer<use.size()  && K>=use.get(pointer)) {
		K = K - use.get(pointer);
		score++;
		pointer++;
	}


	return score;
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


    private static int[] readHealthPoints(BufferedReader br, int a, int b) throws Exception {
    	String[] line = br.readLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]) % (a+b) == 0 ? (a+b) : Integer.parseInt(line[i]) % (a+b);
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

