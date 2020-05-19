import java.io.*;
import java.util.Random;

public class InputCreator {
    public static void main(String[] args) throws IOException {
        System.out.println("INPUT COUNT | LOW | HIGH");
        String read;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("input.txt");
        FileWriter fileWriter = new FileWriter(file);
        String[] line = br.readLine().split(" ");
        Random random = new Random();
        do {
            int count = Integer.parseInt(line[0]);
            int low = Integer.parseInt(line[1]);
            int high = Integer.parseInt(line[2]);
            for (int i = 0; i < count; i++) {
                int result = random.nextInt(high - low) + low;
                if (i < count - 1) fileWriter.write(result + " ");
                else fileWriter.write(result + "");
            }
            fileWriter.write(System.getProperty("line.separator"));
            read = br.readLine();
            if (read.equals("")) {
                break;
            }
            line = read.split(" ");
        } while (read != "");
        fileWriter.close();
    }
}


