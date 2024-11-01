import java.io.*;
import java.util.*;

public class RudolphAndChristmasTree {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }
    
    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++)
            handleTest(br);
    }
    
    private static void handleTest(BufferedReader br) throws IOException {
        int[] nbh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nbh[0];
        int b = nbh[1];
        int h = nbh[2];
        int[] y = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(n,b,h,y);
    }
    
    private static void evaluate(int n, int b, int h, int[] y) {
        double unitArea = 0.5 * b * h; 
        double area = 0.5 * b * h * n;
        double commonArea = 0;
        
        for(int i=1; i<n; i++) {
            int gap = y[i] - y[i-1];
            if (gap<h) {
                double hiddenHight = h-gap;
                commonArea += (hiddenHight*b*hiddenHight/(h*2));
            }
        }
        System.out.println(area - commonArea);
    }
}

/*

6*3
5*2.5


 */