import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int p = scanner.nextInt();
        int[] arr = new int[n];
        int ranking = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if (n == 0) {
        } else if (n < p) {
            for (int i = 0; i < n; i++) {
                if (arr[i] > num) ranking++;
            }
        } else {
            if (arr[n - 1] >= num) ranking = -1;
            else {
                for (int i = 0; i < n; i++) {
                    if (arr[i] > num) ranking++;
                }
            }
        }
        System.out.println(ranking);
        scanner.close();
    }
}