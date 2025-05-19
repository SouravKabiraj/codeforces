import java.io.*;
import java.util.*;

public class GiftCarpet {
    public static void main(String[] arg) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        handleMultiTest(br);
    }

    private static void handleMultiTest(BufferedReader br) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0];
        int c = rc[1];
        // System.out.println(">>" + r + " " + c);
        String[] carpet = new String[r];
        for (int i = 0; i < r; i++) {
            carpet[i] = br.readLine();
            // System.out.println(">>" + carpet[i]);
        }
        execute(r, c, carpet);
    }

    private static void execute(int r, int c, String[] carpet) {
        if (c < 4) {
            System.out.println("NO");
            return;
        }
        List<Character> seq = List.of('v', 'i', 'k', 'a');
        int index = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (carpet[j].charAt(i) == seq.get(index)) {
                    index++;
                    if (index == 4) {
                        System.out.println("YES");
                        return;
                    }
                    break;
                }
            }
        }
        System.out.println("NO");
    }
}

/*
c= 0
r= 0

vbickda
vbickda
vbickda
vbickda


0 -> v
1 -> i
2 -> k
3 -> a
*/