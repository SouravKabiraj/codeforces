import java.io.*;
import java.util.*;

public class SecretPasswords {

    private static int[] set;

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	int N = Integer.parseInt(br.readLine());
	String[] guesses = new String[N];
	for(int i=0; i<N; i++) {
		guesses[i] = br.readLine();
	}
	System.out.println(getMaxTryNeeded(guesses));
    }

    private static int getMaxTryNeeded(String[] gusses) {
    	set = new int[gusses.length];
	Arrays.fill(set,-1);
	for(int i=0; i<gusses.length-1; i++) {
		for(int j=i+1; j<gusses.length; j++) {
			if(isEquivalent(gusses[i],gusses[j])) {
				// System.out.println(gusses[i]+"+ "+ gusses[j]);
				union(gusses,i,j);
			}
		}
	}

	int count =0;
	for(int i=0; i<gusses.length; i++) {
		// System.out.println("->"+set[i]);
		if(set[i] == -1) {
			count++;
		}
	}
	return count;
    }

    private static boolean isEquivalent(String a, String b) {
    	for(int i=0; i<a.length(); i++) {
		for(int j=0; j<b.length(); j++) {
			if(a.charAt(i)==b.charAt(j)) {
				return true;
			}
		}
	}
	return false;
    }

    private static void union(String[] gusses, int i, int j) {
    	int set1 = find(gusses,i);
	int set2 = find(gusses,j);
	
	if(set1<set2) {
		set[set2] = set1;
	}else if(set2<set1) {
		set[set1] = set2;
	}
    }

    private static int find(String[] gusses, int i) {
	    if(set[i]==-1) {
	    	return i;
	    }else {
	    	return find(gusses,set[i]);
	    }
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        print(readArrInt(br));
        System.out.println(readList(br));
        int[][] ar = new int[][]{{1, 2}, {1, 2}};
        print(ar);
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
}

