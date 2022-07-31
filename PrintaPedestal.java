import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintaPedestal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTestCase(br);
    }

    private static void handleMultiTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        execute(N);
    }

    private static void execute(int n) {
        int a, b, c;
        if (n % 3 == 0) {
            a = n / 3 + 1;

        } else {
            a = n / 3 + 2;
        }
        b = a - 1;
        if (n <= a + b) {
            b--;
        }
        c = n - a - b;
        System.out.println(b + " " + a + " " + c);
    }

}


// 18 = 6,6,6 = 7,6,5
// 19 = 7,6,6 = 8,6,5
// 20 = 8,6,6 = 8,7,6
// 21 = 7,7,7 = 8,7,6
// 22 = 8,7,7 = 9,7,6
// 23 = 9,7,7 = 9,8,6
// 24 = 8,8,8 = 9,8,6

/*
if (n%3 == 0) {
    return n/3+1;
}else {
    return n/3+2;
}

11 = 5
6 = 3
10 = 5
100000
7
8

 */
