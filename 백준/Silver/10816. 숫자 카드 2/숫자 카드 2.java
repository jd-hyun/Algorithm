import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        while (st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(key)) {
                int value = hashMap.get(key);
                hashMap.put(key, ++value);
            } else {
                hashMap.put(key, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(key)) {
                sb.append(hashMap.get(key) + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }
}