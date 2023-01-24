import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        int num = 1;

        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();

            while (true) {
                if (stack.empty()) {
                    stack.push(num++);
                    list.add("+");
                } else if (stack.peek() == input) {
                    stack.pop();
                    list.add("-");
                    break;
                } else if (stack.peek() > input) {
                    list.add("NO");
                    break;
                } else {
                    stack.push(num++);
                    list.add("+");
                }
            }
        }
        if (list.contains("NO")) System.out.println("NO");
        else {
            for (String s : list) {
                System.out.println(s);
            }
        }
        scanner.close();
    }
}