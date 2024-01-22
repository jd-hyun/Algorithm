import java.io.*;
import java.util.*;

public class Main {

    static long[] fibonacci;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        fibonacci = new long[79];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int j = 2; j < 79; j++) {
            fibonacci[j] = fibonacci[j - 2] + fibonacci[j - 1];
        }



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