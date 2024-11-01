import java.io.*;
import java.util.*;

public class RudolphAndTicTacToe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        char[][] rows = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String row = br.readLine();
            rows[i][0] = row.charAt(0);
            rows[i][1] = row.charAt(1);
            rows[i][2] = row.charAt(2);
        }
        evaluate(rows);
    }
    
    private static void evaluate(char[][] rows) {
        for(int i=0; i<3; i++) {
            if((rows[i][0] == rows[i][1]) && (rows[i][0] == rows[i][2]) &&  rows[i][0] != '.') {
                System.out.println(rows[i][1]);
                return;
            }
            if((rows[0][i] == rows[1][i]) && (rows[0][i] == rows[2][i]) &&  rows[1][i] != '.') {
                System.out.println(rows[1][i]);
                return;
            }
        }
        if (rows[1][1] == rows[0][0] && rows[1][1] == rows[2][2] && rows[1][1] != '.'){
            System.out.println(rows[1][1]);
            return;
        }
        if (rows[2][0] == rows[1][1] && rows[0][2] == rows[1][1] && rows[1][1] != '.'){
            System.out.println(rows[1][1]);
            return;
        }
        System.out.println("DRAW");
    }
}