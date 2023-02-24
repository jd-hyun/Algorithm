import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n];

        if (n == 1) System.out.println(1);
        else {
            dp[0] = 1;
            dp[1] = 3;

            for (int i = 2; i < n; i++) {
                dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
            }

            System.out.println(dp[n - 1]);
        }
        scanner.close();
    }
}