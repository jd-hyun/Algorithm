import java.util.*;

public class Main {
    static int stairsNum;
    static int[] scores, dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        stairsNum = scanner.nextInt();
        scores = new int[stairsNum];
        dp = new int[stairsNum];

        for (int i = 0; i < stairsNum; i++) {
            scores[i] = scanner.nextInt();
        }

        if (stairsNum == 1) {
            System.out.println(scores[0]);
        } else if (stairsNum == 2) {
            System.out.println(scores[0] + scores[1]);
        } else {
            dp[0] = scores[0];
            dp[1] = scores[0] + scores[1];
            dp[2] = Math.max(scores[0], scores[1]) + scores[2];

            for (int i = 3; i < stairsNum; i++) {
                dp[i] = Math.max(dp[i - 2], scores[i - 1] + dp[i - 3]) + scores[i];
            }
            System.out.println(dp[stairsNum - 1]);
        }
        scanner.close();
    }
}