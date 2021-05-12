import java.io.*;
import java.util.*;

public class PaintTheDigits {
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
        br.readLine();
        String str = br.readLine();
        getOutput(str);
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

    private static void getOutput(String input) {
        if (!fillWith(input, 0, new ArrayList<>(), new ArrayList<>())) {
            System.out.println("-");
        }
    }

    private static boolean fillWith(String input, int index, List<Integer> teamA, List<Integer> teamB) {
        if (index == input.length()) {
            int pointerA = 0;
            int pointerB = 0;
//            System.out.println(teamA);
//            System.out.println(teamB);
            for (int i = 0; i < input.length(); i++) {
                if (pointerA < teamA.size() && teamA.get(pointerA) == i) {
                    System.out.print("1");
                    pointerA++;
                } else {
                    System.out.print("2");
                    pointerB++;
                }
            }
            System.out.println();
            return true;
        } else {
            int curr = input.charAt(index) - '0';
            int lastIndexA = -1;
            int lastIndexB = -1;
            if (teamA.size() > 0)
                lastIndexA = teamA.get(teamA.size() - 1);
            if (teamB.size() > 0)
                lastIndexB = teamB.get(teamB.size() - 1);

            if ((teamA.size() == 0 || ((input.charAt(lastIndexA) - '0') <= curr) && (teamB.size() == 0 || curr <= (input.charAt(teamB.get(0)) - '0')))) {
                teamA.add(index);
                if (fillWith(input, index + 1, teamA, teamB)) {
                    return true;
                }
                teamA.remove(teamA.size() - 1);
            }

            if ((teamB.size() == 0 || (input.charAt(lastIndexB) - '0') <= curr) && (teamA.size() == 0 || (input.charAt(teamA.get(teamA.size() - 1)) - '0') <= curr)) {
                teamB.add(index);
                if (fillWith(input, index + 1, teamA, teamB)) {
                    return true;
                }
                teamB.remove(teamB.size() - 1);
            }
            return false;
        }
    }

}

