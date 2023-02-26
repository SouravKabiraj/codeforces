import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Thermostat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleInput(br);
    }

    private static void handleMultipleInput(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            handleSingleInput(br);
        }
    }

    private static void handleSingleInput(BufferedReader br) throws IOException {
        int[] lrx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = lrx[0];
        int r = lrx[1];
        int x = lrx[2];

        int a = ab[0];
        int b = ab[1];

        System.out.println(calculate(l, r, x, a, b));
    }

    private static int calculate(int l, int r, int x, int a, int b) {
        // step 0
        if (a == b) {
            return 0;
        }
        // step 1
        if ((a > b && a - b >= x) || (b > a && b - a >= x)) {
            return 1;
        }

        // step 2
        if (a < b) {
            if (b + x <= r || a - x >= l) {
                return 2;
            }
        } else {
            if (b - x >= l || a + x <= r) {
                return 2;
            }
        }

        // step 3

        if (a < b) {
            if (a + x <= r && r - l >= x && b - l >= x) {
                return 3;
            }
        } else {
            if (a - x >= l && r - l >= x && r - b >= x) {
                return 3;
            }
        }


        // not possible
        return -1;
    }
}