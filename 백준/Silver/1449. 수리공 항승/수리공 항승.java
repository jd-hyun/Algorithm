import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int[] positions = new int[1000];
        int count = 0;

        for (int i = 0; i < N; i++) {
            int position = scanner.nextInt() - 1;
            positions[position] = 1;
        }

        for (int i = 0; i < 1000; i++) {
            if (positions[i] == 1) {
                i += L - 1;
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}