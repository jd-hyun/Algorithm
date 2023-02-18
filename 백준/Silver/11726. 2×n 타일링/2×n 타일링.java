import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dp = new int[n];
        if (n == 1) {
            System.out.println(1);
        } else {
            dp[0] = 1;
            dp[1] = 2;

            for (int i = 2; i < n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
            }
            System.out.println(dp[n - 1]);
        }
        scanner.close();
    }
}