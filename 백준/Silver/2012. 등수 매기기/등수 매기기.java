import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ranks = new int[N];
        long dissatisfaction = 0;

        for (int i = 0; i < N; i++) {
            ranks[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ranks);

        for (int i = 0; i < N; i++) {
            if (ranks[i] != i + 1) {
                dissatisfaction += Math.abs(i + 1 - ranks[i]);
            }
        }
        System.out.println(dissatisfaction);
    }
}