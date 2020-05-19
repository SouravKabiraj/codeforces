import java.io.*;
import java.util.*;

public class OracAndLCM{
	public static void main(String[] args) throws Exception{
		// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = readInt(br);
		int[] Arr = readArray(br,N);
		System.out.println(getLcmOfGcms(Arr,N));
	}

	private static int readInt(BufferedReader br) throws Exception{
		return Integer.parseInt(br.readLine());
	}

	private static int[] readArray(BufferedReader br,int N) throws Exception{
		String[] inputs = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int i=0; i<N;i++){
			arr[i]=Integer.parseInt(inputs[i]);
		}
		return arr;
	}

	private static int getLcmOfGcms(int[] A,int N) {
		HashMap<Integer,Integer> divCount = new HashMap<Integer,Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<N;i++){
			getDivisor(A[i],divCount);
		}
		for(Map.Entry entry: divCount.entrySet()){
            		if(entry.getValue().equals(N-1)){
				list.add((Integer)entry.getKey());
			}
        	}
		// System.out.println(list);
		return lcm(list);
	}

	private static int lcm(List<Integer> element_array){
      		long lcm_of_array_elements = 1; 
		int divisor = 2; 
		
		while (true) { 
			int counter = 0; 
			boolean divisible = false; 
			
			for (int i = 0; i < element_array.size(); i++) {
				if (0==element_array.get(i)) { 
					return 0;
				} 
				else if (element_array.get(i) < 0) { 
					int temp = element_array.get(i);
					element_array.remove(i);
					element_array.add(i, temp * (-1)); 
				} 
				if (1==element_array.get(i)) { 
					counter++; 
				}  
				if (element_array.get(i) % divisor == 0) { 
					int temp = element_array.get(i);
					divisible = true; 
					element_array.remove(i);
					element_array.add(i,temp / divisor); 
				}
			}
			if (divisible) { 
				lcm_of_array_elements = lcm_of_array_elements * divisor; 
			} 
			else { 
				divisor++; 
			} 
			if (counter == element_array.size()) { 
				return (int)lcm_of_array_elements; 
			} 
	
		}
	}

	private static void getDivisor(int num,HashMap<Integer,Integer> divCount){
		for(int i=1;i<=num/2;i++){
			if(num%i==0){
				if(divCount.containsKey(i)){
					divCount.put(i,divCount.get(i)+1);
				}else {
					divCount.put(i,1);
				}
			}
		}
	}

}
