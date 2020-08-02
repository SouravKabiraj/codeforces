import java.io.*;

public class PrefixSuffixPalindrome {
	public static void main(String[] arg) throws Exception {
		// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++){
			String input = br.readLine();
			// System.out.println("-->" + input);
			System.out.println(getLongest(input));
		}
	}

	private static String getLongest(String str) {
		int pointer = 0;
		int N= str.length();
		while(str.charAt(pointer)==str.charAt(N-pointer-1) && (pointer<N-pointer-1)){
			pointer++;
		}
		String left =  getLeftPalindrom(str,pointer,N-pointer-1);
		String right = getRightPalindrom(str,pointer,N-pointer-1);
		String mid = right.length() > left.length() ? right: left;
		String prefix = str.substring(0,pointer);
		String suffix = str.substring(N-pointer);
		return prefix+mid+suffix;
	}

	private static String getLeftPalindrom(String str,int start, int end) {
		for(;start<=end;end--){
			if(str.charAt(start)==str.charAt(end)){
				if(isPalindrom(str,start,end)){
					return str.substring(start,end+1);
				}
			}
		}
		return "";
	}

	private static String getRightPalindrom(String str, int start, int end) {
		for(;start<=end;start++){
			if(str.charAt(start)==str.charAt(end)){
				if(isPalindrom(str,start,end)){
					return str.substring(start,end+1);
				}
			}
		}
		return "";
	}

	private static boolean isPalindrom(String str, int start, int end) {
		while(start<end) {
			if(str.charAt(start)!=str.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
