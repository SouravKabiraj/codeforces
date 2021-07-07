import java.io.*;
import java.util.*;

public class PlusAndMultiply {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = inputs[0];
        int a = inputs[1];
        int b = inputs[2];
        boolean res = getResult(n, a, b);
        System.out.println(res ? "Yes" : "No");
    }

    private static boolean getResult(int n, int a, int b) {
        long s = 1;
        if (a == 1) {
            return (n - 1) % b == 0;
        }
        while (s <= n) {
            if ((n - s) % b == 0) {
                return true;
            }
            s = s * a;
        }
        return false;
    }

}