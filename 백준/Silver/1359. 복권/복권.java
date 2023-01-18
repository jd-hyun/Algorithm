import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        double result = 0.0;
        int totalCase = combination(n, m);
        while (m >= k) {
            if (n - m < m - k) {
                k++;
                continue;
            }
            double c = combination(m, k) * combination(n - m, m - k);
            result += c / totalCase;
            k++;
        }
        System.out.println(result);
        scanner.close();
    }

    private static int combination(int n, int r) {
        int p = 1;
        int c = 1;
        while (r > 0) {
            p *= n--;
            c *= r--;
        }
        return p / c;
    }
}