import java.io.*;
import java.util.*;

public class RudolfAndTheAnotherCompetition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }
    
    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            handleTest(br);
        }
    }
    
    private static void handleTest(BufferedReader br) throws IOException {
        int[] nmh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmh[0];
        int m = nmh[1];
        int h = nmh[2];
        int[][] probTimes = new int[n][m];
        for(int i=0; i<n; i++) {
            probTimes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(probTimes[i]);
        }
        evaluate(n,m,h,probTimes);
    }
    
    private static void evaluate(int n, int m, int h, int[][] probTimes) {
        TreeSet<Point> results = new TreeSet(); 
        int[] solutionPoints = new int[n];
        int[] timespent = new int[n];
        for(int i=0; i<n; i++) {
            long timeSpent = 0;
            long[][] negPoints = new long[n][m];
            
            int timeleft = h;
            long negPoint = 0;
            for(int j=0; j<m && timeleft >= probTimes[i][j]; j++) {
                negPoints[i][j] = probTimes[i][j] + timeSpent;
                timeSpent = negPoints[i][j];
                
                solutionPoints[i]++;
                timeleft = timeleft - probTimes[i][j];
                negPoint = negPoint + negPoints[i][j];
            }
            results.add(new Point(i, solutionPoints[i], negPoint));
        }
        
        int rank = 0;
        for(Point p: results) {
            rank++;
            if(p.index == 0){
                System.out.println(rank);
                return;
            }
        }
    }
}

class Point implements Comparable<Point> {
    int index;
    int solutionPoint;
    long timePoint;

    Point(int index, int solutionPoint, long timePoint) {
        this.index = index;
        this.solutionPoint = solutionPoint;
        this.timePoint = timePoint;
    }

    public int compareTo(Point o) {
        if(solutionPoint == o.solutionPoint) {
            if  (o.timePoint == timePoint) {
                return index - o.index;
            }
            return o.timePoint < timePoint ? 1: -1 ;
        }
        return o.solutionPoint - solutionPoint;
    }
    
    @Override
    public String toString() {
        return "[" +index+":"+ solutionPoint+  ":" + timePoint + "]";
    }
}
