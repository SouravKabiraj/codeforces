import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RGBSubstring {
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
        int[] nk = readArrInt(br);
        int k = nk[1];
        String str = br.readLine();
        System.out.println(findMinCost(str, k));
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

    private static int findMinCost(String str, int k) {
        char[] offSet = new char[]{'R', 'G', 'B'};
        int cost1 = 0;
        int cost2 = 0;
        int cost3 = 0;
        int[] cost1Arr = new int[str.length()];
        int[] cost2Arr = new int[str.length()];
        int[] cost3Arr = new int[str.length()];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            // System.out.println((i - k));
            char curr = str.charAt(i);
            if (i % 3 == 0) {
                switch (curr) {
                    case 'R':
                        cost1++;
                        if (i >= k) {
                            cost1Arr[i] = cost1 - cost1Arr[i - k];
                        } else {
                            cost1Arr[i] = cost1;
                        }
                        break;
                    case 'G':
                        cost2++;
                        if (i >= k) {
                            cost2Arr[i] = cost2 - cost2Arr[i - k];
                        } else {
                            cost2Arr[i] = cost2;
                        }
                        break;
                    default:
                        cost3++;
                        if (i >= k) {
                            cost3Arr[i] = cost3 - cost3Arr[i - k];
                        } else {
                            cost3Arr[i] = cost3;
                        }
                }
            } else if (i % 3 == 1) {
                switch (curr) {
                    case 'G':
                        cost1++;
                        if (i >= k) {
                            cost1Arr[i] = cost1 - cost1Arr[i - k];
                        } else {
                            cost1Arr[i] = cost1;
                        }
                        break;
                    case 'B':
                        cost2++;
                        if (i >= k) {
                            cost2Arr[i] = cost2 - cost2Arr[i - k];
                        } else {
                            cost2Arr[i] = cost2;
                        }
                        break;
                    default:
                        cost3++;
                        if (i >= k) {
                            cost3Arr[i] = cost3 - cost3Arr[i - k];
                        } else {
                            cost3Arr[i] = cost3;
                        }
                }
            } else {
                switch (curr) {
                    case 'B':
                        cost1++;
                        if (i >= k) {
                            cost1Arr[i] = cost1 - cost1Arr[i - k];
                        } else {
                            cost1Arr[i] = cost1;
                        }
                        break;
                    case 'R':
                        cost2++;
                        if (i >= k) {
                            cost2Arr[i] = cost2 - cost2Arr[i - k];
                        } else {
                            cost2Arr[i] = cost2;
                        }
                        break;
                    default:
                        cost3++;
                        if (i >= k) {
                            cost3Arr[i] = cost3 - cost3Arr[i - k];
                        } else {
                            cost3Arr[i] = cost3;
                        }
                }
            }
            if (i > 0) {
                if (cost1Arr[i] == 0) {
                    cost1Arr[i] = cost1Arr[i - 1];
                }
                if (cost2Arr[i] == 0) {
                    cost2Arr[i] = cost2Arr[i - 1];
                }
                if (cost3Arr[i] == 0) {
                    cost3Arr[i] = cost3Arr[i - 1];
                }
            }
            if (cost1Arr[i] > k) {
                cost1Arr[i] = k;
            }
            if (cost2Arr[i] > k) {
                cost2Arr[i] = k;
            }
            if (cost3Arr[i] > k) {
                cost3Arr[i] = k;
            }

            max = maxVal(max, cost1Arr[i], cost2Arr[i], cost3Arr[i]);
        }
        //print(cost1Arr);
        //print(cost2Arr);
        //print(cost3Arr);
        return k - max;
    }

    private static int maxVal(int a, int b, int c, int d) {
        int max1 = Math.max(a, b);
        int max2 = Math.max(c, d);
        return Math.max(max1, max2);
    }
}

