import java.io.*;
import java.util.*;

public class AirConditioner{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int T = Integer.parseInt(br.readLine());
		// System.out.println(T);
		for(int tc=0; tc<T; tc++) {
			int[] QT = readArray(br);
			int Q = QT[0];
			int startTemp = QT[1];
			int[][] reservations = new int[Q][3];
			// System.out.println(Q+" "+startTemp);
			for(int i=0; i<Q;i++) {
				reservations[i]=readArray(br);
			}

			// System.out.println(QT);
			// System.out.println(reservations);

			if(isSatisfiable(reservations,startTemp)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static int[] readArray(BufferedReader br) throws Exception {
		String[] inputs = br.readLine().split(" ");
		int[] output = new int[inputs.length];
		for(int i=0; i<inputs.length; i++) {
			output[i] = Integer.parseInt(inputs[i]);
		}
		return output;
	}

	private static boolean isSatisfiable(int[][] A, int start) {
		int low = start;
		int high = start;
		int time = 0;

		for(int i=0; i<A.length; i++) {

			int timeDiff = A[i][0]-time;
			low = low - timeDiff;
			high = high + timeDiff;
			time= A[i][0];
			
			int[] startEnd = getOverlap(low,high,A[i][1],A[i][2]);
			low = startEnd[0];
			high = startEnd[1];
			if(low>high) {
				return false;
			}
		}

		return true;
	}


	private static int[] getOverlap(int start1, int end1, int start2, int end2) {
		int start = Math.max(start1,start2);
		int end = Math.min(end1,end2);
		return new int[] {start,end};
	}
}

