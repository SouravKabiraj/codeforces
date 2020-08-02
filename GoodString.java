import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class GoodString {
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
        String text = br.readLine();
        System.out.println(getMinEraseCount(text));
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

    private static int getMinEraseCount(String text) {
	return text.length()- Math.max(getMaxOddLenGoodString(text),getMaxEvenLenGoodString(text));
    }

    private static int getMaxOddLenGoodString(String text) {
    	Map<Character,Integer> charCount =new HashMap<>();
	int maxUse =0;
	for(int i=0; i<text.length(); i++){
		if(!charCount.containsKey(text.charAt(i))){
			charCount.put(text.charAt(i),1);
		}else {
			charCount.put(text.charAt(i),charCount.get(text.charAt(i))+1);
		}
		maxUse = Math.max(maxUse,charCount.get(text.charAt(i)));
	}
	return maxUse;
    }

    private static int getMaxEvenLenGoodString(String text) {
    	int maxR = 0;
	for(int i=0; i<10; i++) {
		for(int j=0; j<10; j++){
			if(i!=j){
				int count = 0;
				for(int ind=0; ind<text.length(); ind++){
					while(ind<text.length() && text.charAt(ind)!=(char)(i+'0')){
						ind++;	
					}
					while(ind<text.length() && text.charAt(ind)!=(char)(j+'0')){
						ind++;
                                	}
					if(ind<text.length())
						count++;
				}
				maxR = Math.max(maxR,count);
			}
		}
	}
	return 2* maxR;
    }
}

