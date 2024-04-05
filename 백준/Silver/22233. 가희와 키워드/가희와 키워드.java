import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String keyword = br.readLine();
            set.add(keyword);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(",");
            int length = split.length;
            for (int j = 0; j < length; j++) {
                if (set.contains(split[j])) {
                    set.remove(split[j]);
                }
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
}