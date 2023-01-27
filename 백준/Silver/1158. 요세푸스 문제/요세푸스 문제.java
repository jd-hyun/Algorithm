import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> queue = new LinkedList<>();
        String result = "<";
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            for (int i = 1; i < m; i++) {
                queue.add(queue.poll());
            }
            result += queue.poll() + ", ";
        }
        result += queue.poll() + ">";
        System.out.println(result);
        scanner.close();
    }
}