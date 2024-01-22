import java.io.*;
import java.util.*;

public class Main {

    static long[] fibonacci;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        fibonacci = generateFibonacci(10000000000000000L);

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            if (isMake(k, x)) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static long[] generateFibonacci(long limit) {
        long[] f = {1, 1};
        while (true) {
            long fi = f[f.length - 1] + f[f.length - 2];
            if (fi > limit) {
                break;
            }
            f = append(f, fi);
        }
        return f;
    }

    private static long[] append(long[] array, long value) {
        long[] newArray = new long[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        return newArray;
    }

    private static boolean isMake(int k, long x) {
        if (k == 1) {
            for (long l : fibonacci) {
                if (l > x) break;
                if (l == x) return true;
            }
        }
        else if (k == 2) {
            for (long l : fibonacci) {
                if (l > x) break;
                for (long l1 : fibonacci) {
                    if (l + l1 > x) break;
                    if (l + l1 == x) return true;
                }
            }
        }

        else {
            for (long l : fibonacci) {
                if (l > x) break;
                for (long l1 : fibonacci) {
                    if (l + l1 > x) break;
                    for (long l2 : fibonacci) {
                        if (l + l1 + l2 > x) break;
                        if (l + l1 + l2 == x) return true;
                    }
                }
            }
        }

        return false;
    }
}