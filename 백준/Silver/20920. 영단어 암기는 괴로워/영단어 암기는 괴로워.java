import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                }
                else {
                    map.put(word, 1);
                    words.add(word);
                }
            }
        }

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) != map.get(o2)) {
                    return map.get(o2) - map.get(o1);
                }

                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }

                return o1.compareTo(o2);
            }
        });

        for (String word : words) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }
}