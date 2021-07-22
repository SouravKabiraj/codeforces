import java.io.*;
import java.util.*;

public class SecretSanta {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCases(br);
        }
    }

    private static void handleTestCases(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var ref = new Object() {
            String result = "";
        };
        Arrays.stream(getSantaList(N, b)).forEach(a -> {
            ref.result = ref.result + a + " ";
        });
        System.out.println(ref.result.substring(0, ref.result.length() - 1));
    }

    private static int[] getSantaList(int n, int[] a) {
        int[] used = new int[n];
        int[] old = new int[n];
        for (int i = 0; i < n; i++) {
            old[i] = a[i];
            a[i]--;
            used[a[i]]++;
        }
        List<Integer> unused = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                unused.add(i);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean placed = false;
            if (used[a[i]] > 1) {
                used[a[i]]--;
                for (int j = 0; j < unused.size(); j++) {
                    if (i != unused.get(j)) {
                        a[i] = unused.get(j);
                        used[unused.get(j)] = 1;
                        unused.remove(j);
                        placed = true;
                        break;
                    }
                }
                if (!placed) {
                    used[a[i]]++;
                }
            }
            a[i] = a[i] + 1;
            if (a[i] == old[i] || !placed) {
                count++;
            }
        }
        System.out.println(count);
        return a;
    }
}
