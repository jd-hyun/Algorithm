import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int gender = scanner.nextInt();
            int position = scanner.nextInt();
            if (gender == 1) {
                for (int j = position; j <= n; j += position) {
                    if (arr[j] == 0) arr[j] = 1;
                    else arr[j] = 0;
                }
            } else {
                if (arr[position] == 0) arr[position] = 1;
                else arr[position] = 0;
                int index = 1;
                while (true) {
                    int temp1 = position - index;
                    int temp2 = position + index;
                    if (temp1 < 1 || temp2 > n) break;
                    if (arr[temp1] != arr[temp2]) break;
                    if (arr[temp1] == 0) arr[temp1] = 1;
                    else arr[temp1] = 0;
                    if (arr[temp2] == 0) arr[temp2] = 1;
                    else arr[temp2] = 0;
                    index++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
        scanner.close();
    }
}