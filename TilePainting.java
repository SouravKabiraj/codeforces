import java.io.*;
import java.util.*;

public class TilePainting {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleTestCase(br);
    }

    private static void handlewMultipleTestCases(BufferedReader br) throws Exception {
        long T = readLong(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        System.out.println(getNumberOfUniqueColor(readLong(br)));
    }

    private static long readLong(BufferedReader br) throws Exception {
        return Long.valueOf(br.readLine());
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

    private static long getNumberOfUniqueColor(long n) {
        Set<Long> list = primeFactors(n);
        // System.out.println(list);
        if (list.size() != 1) {
            return 1;
        }
        long firstElement = (long) list.iterator().next();
        if (firstElement == n) {
            return n;
        }
        return firstElement;
    }

    private static Set<Long> primeFactors(long n) {
        Set<Long> primes = new HashSet<>();
        while (n % 2 == 0) {
            primes.add(2L);
            n /= 2;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primes.add(i);
                n /= i;
            }
        }

        if (n > 2)
            primes.add(n);
        return primes;
    }
}

