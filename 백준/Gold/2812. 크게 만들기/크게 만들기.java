import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] split = s.split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        String input = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            Integer num = input.charAt(i) - '0';
            if (stack.empty()) {
                stack.push(num);
            } else {
                while (!stack.empty() && stack.peek() < num) {
                    stack.pop();
                    count++;
                    if (count == K) {
                        break;
                    }
                }

                stack.push(num);
                if (count == K) {
                    for (int j = i + 1; j < N; j++) {
                        stack.push(input.charAt(j) - '0');
                    }
                    break;
                }
            }
        }

        while (count < K) {
            stack.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}