import java.io.*;
import java.util.*;

public class RudolphAndCutTheRope {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }
    
    private static void handleMultiTest(BufferedReader br) throws IOException  {
          int T = Integer.parseInt(br.readLine());
          for (int i = 0; i < T; i++) {
              handleTest(br);
          }
    }
    
    private static void handleTest(BufferedReader br) throws IOException  {
        int N = Integer.parseInt(br.readLine());
        int[][] ab = new int[N][2];
        for (int i = 0; i < N; i++) {
            ab[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(evaluate(N,ab));
    }
    
    private static int evaluate(int N, int[][] ab){
        int result = 0;
        for (int i=0; i<N; i++){
            result = result + (ab[i][0]<=ab[i][1]?0:1);
        }
        return result;
    }
}