import java.io.*;
import java.util.*;

public class Boredom{
	private static Object[] keys;

    	public static void main(String[] args) throws Exception {
        	// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = readInt(br);
        	TreeMap<Integer, Integer> elementSum = readArr(br, N);
        	keys = elementSum.keySet().toArray();

        	System.out.println(getMaxCoin(elementSum, 0));
    	}

    	private static int getMaxCoin(TreeMap<Integer, Integer> eleSum, int index) {
        	if (index >= eleSum.size()) {
            		return 0;
        	} else {
            		int key = (int) keys[index];
            		int nextKey = eleSum.size();
            		if (index + 1 < eleSum.size())
                		nextKey = (int) keys[index + 1];
            		int case1 = eleSum.get(key) + (nextKey == key + 1 ? getMaxCoin(eleSum, index + 2)
                	    : getMaxCoin(eleSum, index + 1));
            		int case2 = getMaxCoin(eleSum, index + 1);
            		return Math.max(case1, case2);
        	}

    	}

    	private static int readInt(BufferedReader br) throws Exception {
        	return Integer.parseInt(br.readLine());
    	}

    	private static TreeMap<Integer, Integer> readArr(BufferedReader br, int N) throws Exception {
        	String[] inputs = br.readLine().split(" ");
        	TreeMap<Integer, Integer> elementSum = new TreeMap<Integer, Integer>();
        	for (int i = 0; i < N; i++) {
            		int number = Integer.parseInt(inputs[i]);
            		if (elementSum.containsKey(number)) {
                		elementSum.put(number, elementSum.get(number) + number);
            		} else {
                		elementSum.put(number, number);
           		 }
        	}
        	return elementSum;
    	}
}
