import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            String[] split = str.split("");
            int cnt = split.length;
            boolean check = true;
            stack.clear();
            if (cnt % 2 == 0) {
                for (int j = 0; j < cnt; j++) {
                    String s = split[j];
                    if (s.equals("(")) {
                        stack.push(s);
                    } else {
                        if (stack.isEmpty()) {
                            check = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
                if (check && stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
        System.out.println();
    }
}