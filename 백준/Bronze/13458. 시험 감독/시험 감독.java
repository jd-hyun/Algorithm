import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 시험장의 개수
        int[] num = new int[N];

        // 각 시험장에 있는 응시자의 수
        for (int i = 0; i < N; i++) {
            num[i] = scanner.nextInt();
        }

        int B = scanner.nextInt(); // 총감독관이 감시할 수 있는 응시자 수
        int C = scanner.nextInt(); // 부감독관이 감시할 수 있는 응시자 수

        long count = 0;
        for (int i = 0; i < N; i++) {
            count++;
            num[i] -= B;
            if (num[i] <= 0) continue;
            count += (num[i] / C);
            if (num[i] % C != 0) count++;
        }
        System.out.println(count);
    }
}