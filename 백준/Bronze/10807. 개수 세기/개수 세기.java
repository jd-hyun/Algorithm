import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int v = scanner.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == v) cnt++;
        }

        System.out.println(cnt);

    }
}