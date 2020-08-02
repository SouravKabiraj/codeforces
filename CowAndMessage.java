import java.io.*;
import java.util.*;


public class CowAndMessage {
	private static HashMap<String,Integer> strCount = new HashMap<String,Integer>();

	public static void main(String[] args) throws Exception {
		// BufferedReader br= new BufferedReader(new FileReader(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		createAllSubStrings(str,"",0);
		var ref = new Object() {
            		int max = 0;
        	};
		strCount.forEach((key,val)->{
			ref.max = Math.max(ref.max,val);
		});
		System.out.println(ref.max);
	}

	private static void createAllSubStrings(String actual, String prefix, int index) {
		if(index==actual.length()) {
			if(strCount.containsKey(prefix) && prefix!=""){
				strCount.put(prefix,strCount.get(prefix)+1);
			}else {
				strCount.put(prefix,1);
			}
		} else {
			createAllSubStrings(actual,prefix,index+1);
                        createAllSubStrings(actual,prefix+String.valueOf(actual.charAt(index)),index+1);
		}
	}
}
