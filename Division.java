import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Division {
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
        String[] line = br.readLine().split(" ");
	long p = Long.parseLong(line[0]);
	int q = Integer.parseInt(line[1]);
	System.out.println(getDivision(p,q));
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

    private static long getDivision(long p, int q){
	if(p%q!=0){
		return p;
	} else {
		long x =1;
		for(long i=1; i<=Math.sqrt(q); i++) {
			if(q%i==0) {
				long Xm = p;
				while(i!=1 && Xm%i==0) {
					Xm = Xm/i;
					if(Xm%q!=0) {
						x = Math.max(Xm,x);
						break;
					}
				}
				Xm = p;
				while(Xm%(q/i)==0){
					Xm= Xm/(q/i);
					if(Xm%q!=0) {
                                                x = Math.max(Xm,x);
                                                break;
                                        }
				}
			}
		}
		return x;
	}
    }
}

