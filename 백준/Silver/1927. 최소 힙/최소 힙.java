import java.io.*;
import java.util.*;

public class Main {
    static int N, size;
    static int[] minHeap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minHeap = new int[N + 1];
        size = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                sb.append(delete()).append('\n');
            } else {
                insert(x);
            }
        }
        System.out.println(sb);
    }
    private static void insert(int x) {
        int index = ++size;

        while (index != 1 && x < minHeap[index / 2]) {
            minHeap[index] = minHeap[index / 2];
            index /= 2;
        }
        minHeap[index] = x;
    }

    private static int delete() {
        if (size == 0) return 0;
        int min = minHeap[1];
        minHeap[1] = minHeap[size--];
        int parent = 1;
        int child;

        while (true) {
            child = parent * 2;

            if (size > child && minHeap[child] > minHeap[child + 1]) child++;
            if (size < child || minHeap[parent] < minHeap[child]) break;

            int temp = minHeap[child];
            minHeap[child] = minHeap[parent];
            minHeap[parent] = temp;
            parent = child;
        }
        return min;
    }
}