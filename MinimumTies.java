import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MinimumTies {
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
        int num = readInt(br);
        getScores(num);
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

    private static void getScores(int n) {
        int[][] scoreBoard = new int[n][n];
        if (n % 2 == 1) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    scoreBoard[i][j] = (i + j) % 2 == 1 ? 1 : -1;
                    if (i == n - 2 && j == n - 1)
                        System.out.print(scoreBoard[i][j]);
                    else
                        System.out.print(scoreBoard[i][j] + " ");
                }
            }
        } else {
            for (int i = 0; i < n; i = i + 2) {
                scoreBoard[i][i + 1] = 0;
                scoreBoard[i + 1][i] = 0;
                int l = 0;
                for (int j = i + 2; j < n; j++) {
                    if (l % 2 == 0) {
                        scoreBoard[i][j] = 1;
                        scoreBoard[i + 1][j] = -1;
                    } else {
                        scoreBoard[i][j] = -1;
                        scoreBoard[i + 1][j] = 1;
                    }
                    l++;
                }
                for (int j = i + 1; j < n; j++) {
                    if (i == n - 2 && j == n - 1)
                        System.out.print(scoreBoard[i][j]);
                    else
                        System.out.print(scoreBoard[i][j] + " ");
                }
                for (int j = i + 2; j < n; j++) {
                    if (i + 1 == n - 2 && j == n - 1)
                        System.out.print(scoreBoard[i + 1][j]);
                    else
                        System.out.print(scoreBoard[i + 1][j] + " ");
                }
            }
        }
        System.out.println();
    }
}

