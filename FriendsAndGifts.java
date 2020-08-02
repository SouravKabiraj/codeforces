import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class FriendsAndGifts {

    private static boolean[] used;

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
	int[] gifts = readArrInt(br);
    	distribute(gifts);
    }

     private static void distribute(int[] gifts) {
        used = new boolean[gifts.length];
        for (int i = 0; i < gifts.length; i++) {
            used[i] = gifts[i] != 0;
        }
        giveGift(gifts, 0);
        print(gifts);
    }

    private static boolean giveGift(int[] gifts, int i) {
        if (i < gifts.length) {
            if (used[i]) {
                return isValid(gifts, i) && giveGift(gifts, i + 1);
            } else {
                for (int k = 0; k < gifts.length; k++) {
                    gifts[i] = k + 1;
                    if (isValid(gifts, i) && giveGift(gifts, i + 1)) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            return true;
        }
    }

    private static boolean isValid(int[] gifts, int i) {
        if (gifts[i] == i + 1) {
            return false;
        } else {
            boolean flag = true;
            for (int k = 0; k < i; k++) {
                if (gifts[i] == gifts[k]) {
                    flag = false;
                    break;
                }
            }
            for (int k = i + 1; k < gifts.length; k++) {
                if (gifts[i] == gifts[k] && used[k]) {
                    flag = false;
                    break;
                }
            }
            return flag;
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
        for (int i = 0; i < mat.length; i++) {
            if(i<mat.length-1)
		System.out.print(mat[i] + " ");
	    else 
		System.out.println(mat[i]);
        }
    }
}

