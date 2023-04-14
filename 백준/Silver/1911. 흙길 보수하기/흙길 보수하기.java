import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arrayList = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrayList.add(new int[] {start, end});
        }

        Collections.sort(arrayList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o1[0]) {
                    return o1[0] - o2[0];
                }
                else {
                    return o1[1] - o2[1];
                }
            }
        });

        int range = -1;
        for (int i = 0; i < N; i++) {
            int[] arr = arrayList.get(i);
            if (range < arr[0]) {
                range = arr[0];
            }
            while (true) {
                if (arr[1] - 1 < range) break;
                count++;
                range += L;
            }
        }
        System.out.println(count);
    }
}