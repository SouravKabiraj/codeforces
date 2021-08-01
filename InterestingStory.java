import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InterestingStory {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        handleMultipleTestCases(br);
    }

    private static void handleMultipleTestCases(BufferedReader br) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        produceStory(N, words);
    }

    private static void produceStory(int n, String[] words) {
        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Word e = new Word(words[i].length());
            for (int index = 0; index < words[i].length(); index++) {
                e.addLetter(words[i].charAt(index) - 'a');
            }
            wordList.add(e);
        }

        int max = 0;
        for (int i = 0; i < 5; i++) {
            int totalLength = 0;
            int letterLength = 0;
            CompareByIndex compareByIndex = new CompareByIndex().SetLetter(i);
            wordList.sort(compareByIndex);
            for (int j = 0; j < n; j++) {
                Word word = wordList.get(j);
                totalLength = totalLength + word.length;
                letterLength = letterLength + word.letterCount[i];
                if (letterLength > totalLength - letterLength) {
                    max = Math.max(max, j + 1);
                } else {
                    break;
                }
            }
        }
        System.out.println(max);
    }
}

class Word {
    int length;
    int[] letterCount;
    double[] letterPer;

    Word(int len) {
        length = len;
        letterCount = new int[5];
        letterPer = new double[5];
    }

    void addLetter(int index) {
        letterCount[index]++;
        letterPer[index] = (double) letterCount[index] / length;
    }
}

class CompareByIndex implements Comparator<Word> {
    public int letterIndex;

    CompareByIndex SetLetter(int letterIndex) {
        this.letterIndex = letterIndex;
        return this;
    }

    @Override
    public int compare(Word o1, Word o2) {
        return o2.letterPer[letterIndex] > o1.letterPer[letterIndex] ? 1 : -1;
    }
}