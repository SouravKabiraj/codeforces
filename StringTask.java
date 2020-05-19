import java.io.*;
import java.util.*;

public class StringTask {
	public static void main(String[] args) throws Exception{
		// BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String txt = br.readLine();
		getChars(txt);
	}

	private static void getChars(String text){
		for(int i=0;i<text.length();i++){
			char currentChar = text.charAt(i);
			currentChar = Character.toLowerCase(currentChar);
			if(!isVowle(currentChar))
				System.out.print("."+currentChar);
		}
		System.out.println();
	}

	private static boolean isVowle(char ch){
		switch(ch){
			case 'a':
				return true;
			case 'e':
                                return true;
			case 'i':
                                return true;
			case 'o':
                                return true;
			case 'u':
                                return true;
			case 'y':
				return true;
			default:
                                return false;
		}
	}
}
