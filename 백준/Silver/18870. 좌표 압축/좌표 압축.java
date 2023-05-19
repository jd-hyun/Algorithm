import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int token = Integer.parseInt(st.nextToken());
            arr1[i] = token;
            arr2[i] = token;
        }

        Arrays.sort(arr2);
        int count = 0;

        for (int i : arr2) {
            if (!map.containsKey(i)) {
                map.put(i, count++);
            }
        }

        for (int i : arr1) {
            sb.append(map.get(i)).append(' ');
        }

        System.out.println(sb);
    }
}