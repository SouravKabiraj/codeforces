import java.io.*;

public class CountSubrectangles {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int[] NMK = readArrInt(br,3);
		int N = NMK[0];
		int M = NMK[1];
		int K = NMK[2];
		int[] A = readArrInt(br,N);
		int[] B = readArrInt(br,M);
		int[][] C = createC(A,B,N,M);
		print(C);		
	}

	private static int[] readArrInt(BufferedReader br, int N) throws Exception {
		int[] A= new int[N];
		String[] inputs = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			A[i]=Integer.parseInt(inputs[i]);
		}
		return A;
	}

	private static int[][] createC(int[] A, int[] B, int N, int M) {
		int[][] C = new int[N][M];

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++){
				C[i][j] = (A[i] * B[j]);
			}
		}

		return C;
	}

	private static int numberOfAreaWithArea(int[][] M, int K) {
		int[][] R = new int[M.length][M[0].length];
                int[][] C = new int[M.length][M[0].length];
		for(int ) {
			
		}
	}

	private static void print(int[][] M) {
		for(int i=0; i<M.length; i++) {
			for(int j =0; j<M[i].length; j++) {
				System.out.print(M[i][j]);
			}
			System.out.println();
		}
	}
}
