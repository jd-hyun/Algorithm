import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int H = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int P = scanner.nextInt();
        int count = 0;

        int cY = Y + H / 2;

        for (int i = 0; i < P; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x >= X && x <= X + W && y >= Y && y <= Y + H) count++;
            else if ((X - x) * (X - x) + (cY - y) * (cY - y) <= (H / 2) * (H / 2)) count++;
            else if ((X + W - x) * (X + W - x) + (cY - y) * (cY - y) <= (H / 2) * (H / 2)) count++;
        }
        System.out.println(count);
        scanner.close();
    }
}