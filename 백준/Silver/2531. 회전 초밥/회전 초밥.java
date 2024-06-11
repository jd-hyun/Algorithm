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

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(sushi[i])) {
                map.put(sushi[i], map.get(sushi[i]) + 1);
            } else {
                map.put(sushi[i], 1);
            }
        }
        int max = map.size();
        if (!map.containsKey(c)) max++;
        for (int i = 1; i < N; i++) {
            if (map.containsKey(sushi[i - 1])) map.put(sushi[i - 1], map.get(sushi[i - 1]) - 1);
            if (map.get(sushi[i - 1]) == 0) map.remove(sushi[i - 1]);
            if (i + k >= N) {
                if (map.containsKey(sushi[(i + k - 1) % N])) {
                    map.put(sushi[(i + k - 1) % N], map.get(sushi[(i + k - 1) % N]) + 1);
                } else {
                    map.put(sushi[(i + k - 1) % N], 1);
                }
            } else {
                if (map.containsKey(sushi[i + k - 1])) {
                    map.put(sushi[i + k - 1], map.get(sushi[i + k - 1]) + 1);
                } else {
                    map.put(sushi[i + k - 1], 1);
                }
            }
            if (!map.containsKey(c)) {
                max = Math.max(max, map.size() + 1);
            } else {
                max = Math.max(max, map.size());
            }
        }
        System.out.println(max);
    }
}