import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        int count = 0;
        int length = split.length;

        for (int i = 0; i < length; i++) {
            if (split[i].equals("(") && split[i + 1].equals(")")) {
                count += stack.size();
                i++;
            } else if (split[i].equals("(")) {
                stack.push(split[i]);
            } else {
                count++;
                stack.pop();
            }
        }
        System.out.println(count);
    }
}