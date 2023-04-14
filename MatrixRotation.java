import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixRotation {
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
        int[][] arr = new int[2][2];
        arr[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a, b, c, d;

        if (arr[0][0] < arr[0][1] && arr[0][0] < arr[1][0] && arr[0][0] < arr[1][1]) {
            a = arr[0][0];
            b = arr[0][1];
            c = arr[1][0];
            d = arr[1][1];
        } else if (arr[0][1] < arr[0][0] && arr[0][1] < arr[1][0] && arr[0][1] < arr[1][1]) {
            a = arr[0][1];
            b = arr[1][1];
            c = arr[0][0];
            d = arr[1][0];
        } else if (arr[1][1] < arr[0][0] && arr[1][1] < arr[1][0] && arr[1][1] < arr[0][1]) {
            a = arr[1][1];
            b = arr[0][1];
            c = arr[1][0];
            d = arr[0][0];
        } else {
            a = arr[1][0];
            b = arr[0][0];
            c = arr[1][1];
            d = arr[0][1];
        }
        if (a < b && a < c && b < d && c < d) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
/*
a  b
c  d

c  a
d  b

d  c
b  a

b  d
a  c


a < b,c < d

 */