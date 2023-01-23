import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();

        int result = a % b;

        for (int i = 1; i < n; i++) {
            result *= 10;
            result %= b;
        }

        result *= 10;
        System.out.println(result / b);
        scanner.close();
    }
}