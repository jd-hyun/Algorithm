import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();
        int count = 0;

        while (document.length() >= word.length()) {
            int start = document.indexOf(word);
            if (start == -1) break;
            int end = start + word.length() - 1;
            document = document.substring(end + 1, document.length());
            count++;
        }
        System.out.println(count);
    }
}