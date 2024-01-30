import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> queue;

    static boolean[] visited;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        visited = new boolean[100001];
        list = new ArrayList<>();

        bfs(N, K, 0);
    }

    static void bfs(int start, int end, int depth) {
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                if (temp == end) count++;
                addNumber(temp);
                visited[end] = false;
            }
            for (int i1 : list) {
                visited[i1] = true;
            }
            list.clear();
            if (count != 0) {
                System.out.println(depth);
                System.out.println(count);
                return;
            }
            depth++;
        }
    }

    static void addNumber(int temp) {
        if ((temp - 1) >= 0 && !visited[temp - 1]) {
            list.add(temp - 1);
            queue.add(temp - 1);
        }

        if ((temp + 1) < 100001 && !visited[temp + 1]) {
            list.add(temp + 1);
            queue.add(temp + 1);
        }

        if ((temp * 2) < 100001 && !visited[temp * 2]) {
            list.add(temp * 2);
            queue.add(temp * 2);
        }
    }
}