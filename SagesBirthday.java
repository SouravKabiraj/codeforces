import java.io.*;
import java.util.TreeMap;

public class SagesBirthday {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = readInt(br);
        TreeMap<Integer, Integer> set = readArrInt(br);
        showReorderedIceSpheres(set, size);
    }

    private static int readInt(BufferedReader br) throws Exception {
        return Integer.parseInt(br.readLine());
    }

    private static TreeMap<Integer, Integer> readArrInt(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        TreeMap<Integer, Integer> arr = new TreeMap<Integer, Integer>();
        for (int i = 0; i < line.length; i++) {
            int ele = Integer.parseInt(line[i]);
            if (!arr.containsKey(ele)) {
                arr.put(ele, 0);
            }
            arr.put(ele, arr.get(ele) + 1);
        }
        return arr;
    }

    private static void showReorderedIceSpheres(TreeMap<Integer, Integer> map, int size) {
        int[] result = new int[size];
        String resultStr = "";
        int resultCount = 0;
        int i = 1;
        for (var ent : map.entrySet()) {
            int count = ent.getValue();
            while (count > 0 && i < size) {
                result[i] = ent.getKey();
                count--;
                i = i + 2;
                ent.setValue(count);
            }
            if (i >= size) {
                break;
            }
        }
        i = 0;
        for (var ent : map.entrySet()) {
            if (ent.getValue() == 0) {
                continue;
            } else {
                int count = ent.getValue();
                while (count > 0 && i < size) {
                    result[i] = ent.getKey();
                    count--;
                    i = i + 2;
                    ent.setValue(count);
                }
            }
        }
        for (int j = 0; j < size; j++) {
            resultStr = resultStr + result[j] + " ";
            if (0 < j && j < size - 1 && result[j] < result[j - 1] && result[j] < result[j + 1]) {
                resultCount++;
            }
        }
        System.out.println(resultCount);
        System.out.println(resultStr.subSequence(0, resultStr.length() - 1));
    }
}
