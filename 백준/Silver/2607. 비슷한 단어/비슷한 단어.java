import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String firstWord = br.readLine();
        int result = 0;


        for (int i = 1; i < N; i++) {
            String word = br.readLine();
            int[] words = new int[26];

            for (int j = 0; j < firstWord.length(); j++) {
                words[firstWord.charAt(j) - 'A'] += 1;
            }

            int count = 0;
            for (int j = 0; j < word.length(); j++) {
                if (words[word.charAt(j) - 'A'] > 0) {
                    count++;
                    words[word.charAt(j) - 'A'] -= 1;
                }
            }

            if (firstWord.length() == word.length() && (count == firstWord.length() || count == firstWord.length() - 1)) result++;
            if (firstWord.length() == word.length() - 1 && count == firstWord.length()) result++;
            if (firstWord.length() == word.length() + 1 && count == word.length()) result++;
        }

        System.out.println(result);
    }
}