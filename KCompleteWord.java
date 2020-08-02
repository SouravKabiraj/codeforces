import java.io.*;

public class KCompleteWord{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			int testCase = tc * 2;
			int[] NK = readArray(br,2);
			// System.out.println("K = "+NK[1]);
			System.out.println("N = "+NK[0]);
			char[] str = readChars(br,NK[0]);
			System.out.println(getMinCost(str,NK[1],NK[0]));
		}
	}

	private static int getMinCost(char[] ch, int K, int N) {
		int[][] charCount = new int[(K/2)+(K%2)][26];
		for(int i=0;i<N/K;i++) {
			// System.out.println("i --->" + i);
			for(int s=0;s<K/2;s++){
				int j = i*K+s;
				int m = (i+1)*K-s-1;
				// System.out.println("j ->" + j);
                                // System.out.println("m ->" + m);

				charCount[s][ch[j]-'a']++;
				charCount[s][ch[m]-'a']++;
			}
			if(K%2==1){
				int r = (K/2);
				// System.out.println("r ->" + r);
				charCount[r][ch[i*K+(K/2)+1]-'a']++;
			}
		}
		print(charCount);
		
		int count = 0;
		for(int i=0;i<(K/2)+(K%2);i++){
			int max = 0;
			for(int l = 0; l<26;l++){
				max = Math.max(charCount[i][l],max);
			}
			count= count+max;
		}


		return N-count;
	}

	private static void print(int[][] A) {
		for(int i=0;i<A.length;i++) {
			for(int j=0; j<26; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}


	private static char[] readChars(BufferedReader br, int N) throws Exception {
		char[] str = new char[N];
		String inputs = br.readLine();
		System.out.println(inputs);
		for(int i=0; i<N; i++){
			str[i] = inputs.charAt(i);
		}
		return str;
	}

	private static int[] readArray(BufferedReader br, int N) throws Exception {
		int[] A = new int[N];
		String[] inputs = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(inputs[i]);
		}
		return A;
	}
}
