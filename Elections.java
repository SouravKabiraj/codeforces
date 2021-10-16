import java.io.*;
import java.util.*;

public class Elections {
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
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (a[0] > a[1] && a[0] > a[2]) {
            System.out.println(0 + " " + (a[0] - a[1] + 1) + " " + (a[0] - a[2] + 1));
        } else if (a[1] > a[0] && a[1] > a[2]) {
            System.out.println((a[1] - a[0] + 1) + " 0 " + (a[1] - a[2] + 1));
        } else if (a[2] > a[0] && a[2] > a[1]) {
            System.out.println((a[2] - a[0] + 1) + " " + (a[2] - a[1] + 1) + " 0");
        } else if (a[0] == a[1] && a[0] > a[2]) {
            System.out.println("1 1 " + (a[0] - a[2] + 1));
        } else if (a[0] > a[1] && a[0] == a[2]) {
            System.out.println("1 " + (a[0] - a[1] + 1) + " 1");
        } else if (a[0] < a[1] && a[1] == a[2]) {
            System.out.println((a[1] - a[0] + 1) + " 1 1");
        } else {
            System.out.println("1 1 1");
        }
    }
}