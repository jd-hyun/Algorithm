import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] dolls = new int[n];
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            dolls[i] = scanner.nextInt();
            if (dolls[i] == 1) {
                list.add(i);
            }
        }

        int size = list.size();

        if (size < k) {
            System.out.println(-1);
        } else {
            for (int start = 0; start < size; start++) {
                int end = start;
                int cnt = 0;

                while (end < size && cnt < k) {
                    end++;
                    cnt++;
                }
                if (cnt == k) {
                    int tmp = list.get(end - 1) - list.get(start) + 1;
                    min = Math.min(min, tmp);
                }
            }
            System.out.println(min);
        }
        scanner.close();
    }
}