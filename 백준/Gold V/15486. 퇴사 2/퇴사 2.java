import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            T[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}