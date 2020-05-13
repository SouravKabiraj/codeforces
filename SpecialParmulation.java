import java.io.*;

public class SpecialParmulation {
	public static void main(String args[]) throws Exception{
		// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = readSingleInt(br);
		for(int tc=0; tc<T;tc++){
			int N = readSingleInt(br);
			log(getSpecialParmutation(N));	
		}
	}

	private static int[] getSpecialParmutation(int N){
		int[] list = new int[N];
		if(place(list,N,0)){
	       		return list;
		}else {
			int[] A = new int[1];
			A[0] = -1;
			return A;
		}
	}

	private static boolean place(int[] list,int N, int index){
		if(index<N){
			for(int i=1;i<=N;i++){
				list[index] = i;
				if(isValid(list,index) && place(list,N,index+1)){
					return true;
				}
			}
			return false;
		}else {
			return true;
		}
	}

	private static boolean isValid(int[] list,int index){
		if(index==0) return true;
		else {
			int diff = Math.abs(list[index]-list[index-1]);
			if(diff>1 && diff<5) {
				for(int i=0;i<index;i++){
					if(list[index]==list[i]){
						return false;
					}
				}
				return true; 
			}else {
				return false;
			}
		}
	}

	private static int readSingleInt(BufferedReader br) throws Exception{
		return Integer.parseInt(br.readLine());
	}

	private static void log(int[] list){
		for(int i=0; i<list.length;i++){
			System.out.print(list[i]+" ");
		}
		System.out.println();
	}
}
