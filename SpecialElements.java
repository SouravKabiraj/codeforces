import java.util.*;
import java.io.*;


public class SpecialElements{
	private static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0;i<T;i++){
			int N = Integer.parseInt(br.readLine());
			int[] A=  readIntArr(br,N);
			System.out.println(getCountOfSpecialElement(A));
		}
	}

	private static int[] readIntArr(BufferedReader br, int N) throws Exception {
		int[] A = new int[N];
		String[] strs = br.readLine().split(" ");
		for(int i=0;i<N;i++){
			A[i] = Integer.parseInt(strs[i]);
			max = Math.max(max,A[i]);
		}
		return A;
	}

	private static int getCountOfSpecialElement(int[] elements){
		int N= elements.length;
		HashMap<Integer,Integer> sums = new HashMap<Integer,Integer>();
		for(int i=0;i<N;i++){
			int init = 0;
			for(int j=i;j<N;j++){
				if(i==j){
					init=elements[i];
				} else {
					init = init + elements[j];
					if(init>max){
						break;
					}
					sums.put(init,1); 
				}
			}
		}

		int count= 0;
		for(int i=0;i<N;i++){
			if(sums.containsKey(elements[i])){
				count++;
			}
		}
		return count;
	}
}
