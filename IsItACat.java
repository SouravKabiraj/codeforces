import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsItACat {
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
        String sound = br.readLine();
        evaluate(N, sound);
    }

    private static void evaluate(int n, String sound) {
        if (!(sound.charAt(0) == 'm' || sound.charAt(0) == 'M')) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            char ch = sound.charAt(i);
            switch (ch) {
                case 'm':
                case 'M':
                    if ((sound.charAt(i + 1) == 'e' || sound.charAt(i + 1) == 'E' || sound.charAt(i + 1) == 'm' || sound.charAt(i + 1) == 'M')) {
                        continue;
                    } else {
                        System.out.println("NO");
                        return;
                    }

                case 'e':
                case 'E':
                    if ((sound.charAt(i + 1) == 'e' || sound.charAt(i + 1) == 'E' || sound.charAt(i + 1) == 'o' || sound.charAt(i + 1) == 'O')) {
                        continue;
                    } else {
                        System.out.println("NO");
                        return;
                    }


                case 'o':
                case 'O':
                    if ((sound.charAt(i + 1) == 'w' || sound.charAt(i + 1) == 'W' || sound.charAt(i + 1) == 'o' || sound.charAt(i + 1) == 'O')) {
                        continue;
                    } else {
                        System.out.println("NO");
                        return;
                    }

                case 'w':
                case 'W':
                    if ((sound.charAt(i + 1) == 'w' || sound.charAt(i + 1) == 'W')) {
                        continue;
                    } else {
                        System.out.println("NO");
                        return;
                    }

                default:
                    System.out.println("NO");
                    return;

            }
        }
        if (sound.charAt(n - 1) == 'w' || sound.charAt(n - 1) == 'W') {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}