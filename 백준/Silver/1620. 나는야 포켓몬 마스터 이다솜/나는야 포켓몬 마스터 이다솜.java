import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            list.add(pokemon);
            map.put(pokemon, i);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String line = br.readLine();

            if (map.containsKey(line)) {
                sb.append(map.get(line)).append("\n");
            } else {
                sb.append(list.get(Integer.parseInt(line) - 1)).append("\n");
            }
        }

        System.out.println(sb);
    }
}