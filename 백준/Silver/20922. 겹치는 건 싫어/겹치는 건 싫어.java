import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        list.add(sequence[0]);
        map.put(sequence[0], 1);
        dp[0] = 1;
        int length = 1;

        for (int i = 1; i < N; i++) {
            list.add(sequence[i]);


            if (map.containsKey(sequence[i])) {
                map.put(sequence[i], map.get(sequence[i]) + 1);
                if (map.get(sequence[i]) > K) {
                    int index = list.indexOf(sequence[i]);
                    length -= index;
                    for (int j = 0; j <= index; j++) {
                        int removed = list.remove(0);
                        if (map.containsKey(removed)) {
                            map.put(removed, map.get(removed) - 1);
                        }
                    }
                } else {
                    length += 1;
                }
            } else {
                map.put(sequence[i], 1);
                length += 1;
            }
            dp[i] = Math.max(dp[i - 1], length);
        }

        System.out.println(dp[N - 1]);
    }
}