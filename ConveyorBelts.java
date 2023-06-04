import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConveyorBelts {
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
        int[] nx1y1x2y2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nx1y1x2y2[0];
        int x1 = nx1y1x2y2[1];
        int y1 = nx1y1x2y2[2];
        int x2 = nx1y1x2y2[3];
        int y2 = nx1y1x2y2[4];
        evaluate(n, x1, y1, x2, y2);
    }

    private static void evaluate(int n, int x1, int y1, int x2, int y2) {
        int numberOfOrbits = n / 2;
        int orbit1x = (x1 > numberOfOrbits) ? Math.abs(x1 - numberOfOrbits - 1) : Math.abs(numberOfOrbits - x1);
        int orbit1y = (y1 > numberOfOrbits) ? Math.abs(y1 - numberOfOrbits - 1) : Math.abs(numberOfOrbits - y1);
        // System.out.println(orbit1x + " " + orbit1y);
        int orbit1 = Math.max(orbit1x, orbit1y);
        int orbit2x = (x2 > numberOfOrbits) ? Math.abs(x2 - numberOfOrbits - 1) : Math.abs(numberOfOrbits - x2);
        int orbit2y = (y2 > numberOfOrbits) ? Math.abs(y2 - numberOfOrbits - 1) : Math.abs(numberOfOrbits - y2);
        int orbit2 = Math.max(orbit2x, orbit2y);
        // System.out.println(orbit2x + " " + orbit2y);
        System.out.println(Math.abs(orbit1 - orbit2));
    }
}
