import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] arr = new String[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String pokemon = br.readLine();
            hashMap.put(pokemon, i);
            arr[i] = pokemon;
        }

        for (int i = 0; i < M; i++) {
            String problem = br.readLine();
            try {
                sb.append(arr[Integer.parseInt(problem) - 1]);
            } catch (NumberFormatException e) {
                sb.append(hashMap.get(problem) + 1);
            } finally {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}