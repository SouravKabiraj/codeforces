import java.util.*;
import java.io.*;

public class NeedForPinkSlips {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCase(br);
    }

    private static void handleMultipleTestCase(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        double[] cmpv = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::valueOf).toArray();
        double c = cmpv[0];
        double m = cmpv[1];
        double p = cmpv[2];
        double v = cmpv[3];
        System.out.println(getTotalProbability(c, m, p, v, 1, 1));
    }

    private static double getTotalProbability(double c, double m, double p, double v, double t, int pre) {
        double total = 0;
        if (c > 0 && c <= v) {
            if (m > 0) {
                total = total + getTotalProbability(0, m + c / 2, p + c / 2, v, t * c, pre + 1);
            } else {
                total = total + getTotalProbability(0, m, p + c, v, t * c, pre + 1);
            }
        }
        if (c > 0 && c > v) {
            if (m > 0) {
                total = total + getTotalProbability(c - v, m + v / 2, p + v / 2, v, t * c, pre + 1);
            } else {
                total = total + getTotalProbability(c - v, m, p + v, v, t * c, pre + 1);
            }
        }
        if (m > 0 && m <= v) {
            if (c > 0) {
                total = total + getTotalProbability(c + m / 2, 0, p + m / 2, v, t * m, pre + 1);
            } else {
                total = total + getTotalProbability(c, 0, p + m, v, t * m, pre + 1);
            }
        }
        if (m > 0 && m > v) {
            if (c > 0) {
                total = total + getTotalProbability(c + v / 2, m - v, p + v / 2, v, t * m, pre + 1);
            } else {
                total = total + getTotalProbability(c, m - v, p + v, v, t * m, pre + 1);
            }
        }
        total = total + t * p * pre;
        return total;
    }
}