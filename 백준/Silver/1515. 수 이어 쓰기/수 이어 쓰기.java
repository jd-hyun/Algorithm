import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = 0;
        int index = 0;

        while (true) {
            result++;
            String temp = Integer.toString(result);
            int length = temp.length();
            for (int i = 0; i < length; i++) {
                if (temp.charAt(i) == s.charAt(index))
                    index++;
                if (index == s.length()) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}