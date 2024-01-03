import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] arr;
    static boolean[] visited;
    static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(a, b, 0);
        System.out.println(count);
    }

    static void dfs(int start, int end, int cnt) {
        if (start == end) {
            count = cnt;
            return;
        }

        visited[start] = true;
        for (int i = 0; i < arr[start].size(); i++) {
            int next = arr[start].get(i);
            if (!visited[next]) {
                dfs(next, end, cnt + 1);
            }
        }

    }
}