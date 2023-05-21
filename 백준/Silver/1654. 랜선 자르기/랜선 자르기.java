import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static int[] lanLines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lanLines = new int[K];
        long min = 1;
        long max = 0;

        for (int i = 0; i < K; i++) {
            lanLines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanLines[i]);
        }
        System.out.println(binarySearch(min, max));
    }

    private static long binarySearch(long min, long max) {
        while (min <= max) {
            long mid = (min + max) / 2;
            int count = 0;

            for (int lanLine : lanLines) {
                count += lanLine / mid;
            }

            if (count < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (min + max) / 2;
    }
}