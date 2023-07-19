import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RoundDance {
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
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(n, a);
    }

    private static void evaluate(int n, int[] a) {
        int[] setNumber = new int[n];
        HashMap<Integer, Integer> setCount = new HashMap<>();
        HashMap<Integer, Set<Edge>> setEdges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            union(setNumber, i + 1, a[i]);
        }
        for (int i = 0; i < n; i++) {
            int mySet = find(setNumber, i + 1);
            setEdges.putIfAbsent(mySet, new HashSet<>());
            setEdges.get(mySet).add(new Edge(i + 1, a[i]));
            setCount.putIfAbsent(mySet, 0);
            setCount.put(mySet, setCount.get(mySet) + 1);
        }
        int connectedGraph = 0;
        int openGraph = 0;

        for (Integer s : setEdges.keySet()) {
//            System.out.println("EDGES " + s + " : " + setEdges.get(s).size());
//            System.out.println("NODES " + s + " : " + setCount.get(s));
            if (setEdges.get(s).size() == setCount.get(s)) {
                connectedGraph++;
            } else {
                openGraph++;
            }
        }
//        System.out.println("open: " + openGraph + ", connected:" + connectedGraph);
        int max = connectedGraph + openGraph;
        int min = connectedGraph + ((openGraph > 0) ? 1 : 0);
        System.out.println(min + " " + max);
    }

    private static int find(int[] setNumber, int person) {
        if (setNumber[person - 1] == 0 || setNumber[person - 1] == person) {
            return person;
        }
        return find(setNumber, setNumber[person - 1]);
    }

    private static void union(int[] setNumber, int person1, int person2) {
        int person1set = find(setNumber, person1);
        int person2set = find(setNumber, person2);
        if (person1set > person2set) {
            setNumber[person1set - 1] = person2set;
        } else {
            setNumber[person2set - 1] = person1set;
        }
    }
}

class Edge {
    int low;
    int high;

    Edge(int person1, int person2) {
        low = Math.min(person1, person2);
        high = Math.max(person1, person2);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Edge)) {
            return false;
        }
        Edge other = (Edge) obj;
        return low == other.low && high == other.high;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "[" + low + "-" + high + "]";
    }
}