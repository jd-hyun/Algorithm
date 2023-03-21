import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            int length = s.length();
            stack.clear();
            boolean check = true;
            for (int i = 0; i < length; i++) {
                char temp = s.charAt(i);
                if (temp == '(' || temp == '[') {
                    stack.push(temp);
                } else if (temp == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        check = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (temp == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        check = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (check && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}