import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (String s : split) {
            stack1.push(s);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            switch (token) {
                case "L":
                    if (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    break;
                case "D":
                    if (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                    break;
                case "B":
                    if (!stack1.isEmpty()) {
                        stack1.pop();

                    }
                    break;
                case "P":
                    stack1.push(st.nextToken());
                    break;
            }
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }

        System.out.println(sb);

    }
}