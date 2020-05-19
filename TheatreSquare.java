import java.io.*;
import java.util.*;

public class TheatreSquare{
	public static void main(String[] args) throws Exception{
		// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] NMA =  read(br);
		long N = NMA[0];
		long M = NMA[1];
		long A = NMA[2];
		long row = (long)((double)N/(double)A);
		long col = (long)((double)M/(double)A);
		// System.out.println(row);
		// System.out.println(col);
		row = row + ((N%A==0)?0:1);
		col = col + ((M%A==0)?0:1);
		System.out.println(row*col);
	}

	private static long[] read(BufferedReader br) throws Exception {
		String[] inputs = br.readLine().split(" ");
		long[] A= new long[inputs.length];
		for(int i=0;i<inputs.length;i++){
			A[i] = Long.parseLong(inputs[i]);
		}
		return A;
	}

}
