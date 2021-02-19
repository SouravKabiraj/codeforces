import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryStringMinimizing {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        int[] inputs = readArrInt(br);
	int count = inputs[1];
	String str = br.readLine();
	int[] chars = getChars(str);
	int[] result =  getMin(chars,count);
	for(int i=0; i<result.length; i++) {
		System.out.print(result[i]);
	}
	System.out.println();
    }

    private static int[] getChars(String str) {
    	int[] chars = new int[str.length()];
	for(int i=0; i<str.length(); i++) {
		chars[i] = str.charAt(i)-'0';
	}
	return chars;
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
        System.out.print("{");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println("}");
    }

    private static int[] getMin(int[] str, int count) {
int pointer = 0;
        for (int i = 0; i < str.length && count >= 0 && pointer < str.length; i++) {
            if (str[i] == 0) continue;
            while (pointer < str.length && str[pointer] == 1 && pointer - i < count) {
                pointer++;
            }
            if (pointer < str.length && str[pointer] == 0 && pointer - i <= count) {
                str[i] = 0;
                str[pointer] = 1;
                count = count - (pointer - i);
            }
        }
        return str;
    }
}

