import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < postfix.length(); i++) {
            switch (postfix.charAt(i)) {
                case '+':
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);
                    break;
                case '-':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case '*':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case '/':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push((double)arrayList.get(postfix.charAt(i) - 'A'));
                    break;
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}