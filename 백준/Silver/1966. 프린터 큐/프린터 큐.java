import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<int[]> queue = new LinkedList<>();
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int count = 1;

            for (int j = 0; j < n; j++) {
                int[] list = {j, scanner.nextInt()};
                queue.add(list);
            }
            while (!queue.isEmpty()) {
                boolean biggest = true;
                for (int j = 0; j < queue.size(); j++) {
                    if (queue.get(j)[1] > queue.peek()[1]) {
                        queue.add(queue.poll());
                        biggest = false;
                        break;
                    }
                }

                if (biggest) {
                    if (queue.peek()[0] == m) break;
                    count++;
                    queue.poll();
                }
            }
            System.out.println(count);
            queue.clear();
        }
        scanner.close();
    }
}