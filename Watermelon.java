import java.io.*;

public class Watermelon {
	public static void main(String args[]) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int wgt = Integer.parseInt(br.readLine());
		if((wgt-2)%2==0 && (wgt-2)>0){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
