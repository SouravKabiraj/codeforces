import java.io.*;
import java.util.*;

public class ArrayStabilizationANDVersion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTest(br);
    }

    private static void handleMultipleTest(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTest(br);
        }
    }

    private static void handleTest(BufferedReader br) throws IOException {
        int[] nd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nd[0];
        int d = nd[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        evaluate(d, arr);
    }

    private static void evaluate(int d, int[] arr) {
        Map<Integer, LinkedNode> indexNode = new HashMap<>();
        int max = 0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexNode.put(i, new LinkedNode(i, arr[i]));
        }
        for (int i = 0; i < d; i++) {
            LinkedNode head = indexNode.get(i);
            LinkedNode pointer = head;
            do {
                LinkedNode nextPointer = indexNode.get((pointer.index + arr.length + d) % arr.length);
                pointer.next = nextPointer;
                visited[pointer.index] = true;
                pointer = pointer.next;
            } while (!visited[pointer.index]);
        }
        for (int i = 0; i < d; i++) {
            LinkedNode head = indexNode.get(i);
            LinkedNode pointer = head;
            visited = new boolean[arr.length];
            int space = 0;
            int initSpace = 0;
            boolean flag = false;
            boolean infinity = true;
            do {
                if (arr[pointer.index] == 0) {
                    space = 0;
                    flag = true;
                    infinity = false;
                } else {
                    space++;
                    if (!flag) {
                        initSpace++;
                    }
                }
                LinkedNode nextPointer = indexNode.get((pointer.index + arr.length + d) % arr.length);
                pointer.next = nextPointer;
                visited[pointer.index] = true;
                pointer = pointer.next;
                max = Math.max(max, space);
            } while (!visited[pointer.index]);
            max = Math.max(max, space + initSpace);
            if (infinity) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(max);
    }
}

class LinkedNode {
    int index;
    int value;
    LinkedNode next;

    LinkedNode(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

