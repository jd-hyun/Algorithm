import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        visited = new boolean[100001];

        bfs(N, K, 0);
    }

    static void bfs(int start, int end, int depth) {
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                if (temp == end) {
                    System.out.println(depth);
                    return;
                }
                addNumber(temp);
            }
            depth++;
        }
    }

    static void addNumber(int temp) {
        if ((temp - 1) >= 0 && !visited[temp - 1]) {
            visited[temp - 1] = true;
            queue.add(temp - 1);
        }

        if ((temp + 1) < 100001 && !visited[temp + 1]) {
            visited[temp + 1] = true;
            queue.add(temp + 1);
        }

        if ((temp * 2) < 100001 && !visited[temp * 2]) {
            visited[temp * 2] = true;
            queue.add(temp * 2);
        }
    }
}