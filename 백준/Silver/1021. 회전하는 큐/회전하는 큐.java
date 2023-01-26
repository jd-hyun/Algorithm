import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> queue = new LinkedList<>();
        int count = 0;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        for (int i = 0; i < m; i++) {
            int position = scanner.nextInt();
            int index = queue.indexOf(position);
            if (index <= queue.size() / 2) {
                for (int j = 0; j < index; j++) {
                    queue.add(queue.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < queue.size() - index; j++) {
                    queue.addFirst(queue.pollLast());
                    count++;
                }
            }
            queue.remove();
        }
        System.out.println(count);
        scanner.close();
    }
}