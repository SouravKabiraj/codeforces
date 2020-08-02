import java.io.*;
import java.util.*;

public class PoweredAddition {
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T;tc++){
			int N = Integer.parseInt(br.readLine());
			long[] A = readArr(br,N);
			System.out.println(getTimeTaken(A));
		}
	}

	private static long[] readArr(BufferedReader br,int N) throws Exception {
		long[] A = new long[N];
		long[] C = new long[N-1];
		String[] inputs = br.readLine().split(" ");
		for(int i=0;i<N;i++){
			A[i] = Long.parseLong(inputs[i]);
			if(i>0) {
				C[i-1] = A[i] - A[i-1];
			}
		}
		return C;
	}


	private static void printArr(long[] A) {
		for(int i=0; i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}

	private static int getTimeTaken(long[] A) {
		int time = 0;
		for(int i=0; i<A.length;i++) {
			while(A[i]<0) {
				time++;
				A[i] = A[i] + getNumber(time);
			}
		}
		return time;
	}

	private static long getNumber(int time) {
		return (long) Math.pow(2,(time-1));
	}
}
