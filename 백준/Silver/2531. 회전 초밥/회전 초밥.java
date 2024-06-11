import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                if (j >= N) set.add(sushi[j % N]);
                else set.add(sushi[j]);
            }
            if (!set.contains(c)) {
                max = Math.max(max, set.size() + 1);
            } else {
                max = Math.max(max, set.size());
            }
        }
        System.out.println(max);
    }
}