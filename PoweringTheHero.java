import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class PoweringTheHero {
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
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(N, arr);
    }

    private static void evaluate(int n, int[] arr) {
        long total = 0;
        TreeSet<Card> cards = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (cards.size() == 0) {
                    continue;
                }
                Card first = cards.first();
                total = first.power + total;
                cards.remove(first);
            } else {
                cards.add(new Card(i, arr[i]));
                // System.out.println(cards);
            }
        }
        System.out.println(total);
    }

}

class Card implements Comparable<Card> {
    int index;
    int power;

    Card(int i, int p) {
        index = i;
        power = p;
    }

    @Override
    public String toString() {
        return "[" + this.index + ":" + this.power + "]";
    }

    @Override
    public int compareTo(Card o) {
        if (this.power == o.power) {
            return this.index - o.index;
        } else {
            return o.power - this.power;
        }
    }
}
