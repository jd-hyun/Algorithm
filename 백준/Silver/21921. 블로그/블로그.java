import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitors = new int[N];
        long maxVisited = 0;
        Map<Long, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
            maxVisited = Math.max(maxVisited, visitors[i]);
        }

        if (maxVisited == 0) System.out.println("SAD");

        else {
            long sum = 0;
            for (int i = 0; i < X; i++) {
                sum += visitors[i];
            }
            maxVisited = sum;
            map.put(maxVisited, 1);
            for (int i = X; i < N; i++) {
                 sum -= visitors[i - X];
                 sum += visitors[i];
                if (sum >= maxVisited) {
                    maxVisited = sum;
                    if (map.containsKey(maxVisited)) {
                        map.put(maxVisited, map.get(maxVisited) + 1);
                    }
                    else {
                        map.put(maxVisited, 1);
                    }
                }
            }
            System.out.println(maxVisited);
            System.out.println(map.get(maxVisited));
        }
    }
}