import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sub = new int[n];
        int t = 0;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            sub[i] = b - a;
        }
        Arrays.sort(sub);

        if (n % 2 == 0) System.out.println(Math.abs(sub[n / 2] - sub[n /2 - 1]) + 1);
        else System.out.println(1);
        scanner.close();
    }
}