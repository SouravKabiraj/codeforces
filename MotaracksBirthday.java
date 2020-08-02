import java.io.*;
import java.util.*;

public class MotaracksBirthday {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = readArray(br);
			printKAndM(A,N);
		}
	}

	private static void printKAndM(int[] A, int N) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int i=0; i<N; i++) {
			if(i>0 && A[i]==-1 && A[i-1]!=-1){
				max = Math.max(max,A[i-1]);
				min = Math.min(min,A[i-1]);
			}

			if(i<N-1 && A[i]==-1 && A[i+1]!=-1){
				max = Math.max(max,A[i+1]);
                                min = Math.min(min,A[i+1]);
			}
		}

		int K = Math.abs((min+max)/2);
		int diff = 0;

		for(int i=0; i<N; i++) {
			if(A[i]==-1) A[i]=K;

			if(i>0) {
				diff = Math.max(diff,Math.abs(A[i]-A[i-1]));
			}
		}

		System.out.println(diff + " "+ K);
	}

	private static int[] readArray(BufferedReader br) throws Exception {
		String[] inputs = br.readLine().split(" ");
		int[] outputs = new int[inputs.length];
		for(int i=0;i<inputs.length; i++) {
			outputs[i] = Integer.parseInt(inputs[i]);
		}
		return outputs;
	}
}
