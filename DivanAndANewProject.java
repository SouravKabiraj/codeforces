import java.io.*;
import java.util.*;

public class DivanAndANewProject {
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
        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, a);
    }

    private static void evaluate(int n, int[] a) {
        TreeSet<MyPair> myPairs = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            myPairs.add(new MyPair(a[i], i));
        }
        int[] place = new int[n + 1];
        place[0] = 0;
        int result = 0;
        int left = 0;
        int right = 0;
        boolean isLeft = false;
        for (MyPair p : myPairs) {
            if (isLeft) {
                left++;
                result = result + left * 2 * p.a;
                place[p.b + 1] = left;
            } else {
                right++;
                result = result + right * 2 * p.a;
                place[p.b + 1] = -1 * right;
            }
            isLeft = !isLeft;
        }
        System.out.println(result);
        for (int i = 0; i <= n; i++) {
            System.out.print(place[i] + " ");
        }
        System.out.println();
    }
}


class MyPair implements Comparable<MyPair> {
    int a;
    int b;

    public MyPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int compareTo(MyPair st) {
        if (a == st.a)
            return b - st.b;
        else
            return st.a - a;
    }
}