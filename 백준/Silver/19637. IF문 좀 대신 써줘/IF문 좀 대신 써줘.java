import java.io.*;
import java.rmi.dgc.VMID;
import java.util.*;

class Character {
    private String style;

    private int upperLimit;

    public String getStyle() {
        return this.style;
    }

    public int getUpperLimit() {
        return this.upperLimit;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setUpperLimit(int upperLimit) {
        this.style = style;
    }

    public Character() {
    }

    public Character(String style, int upperLimit) {
        this.style = style;
        this.upperLimit = upperLimit;
    }
}

public class Main {

    static int N, M;

    static Character[] characters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        characters = new Character[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String style = st.nextToken();
            int upperLimit = Integer.parseInt(st.nextToken());
            characters[i] = new Character(style, upperLimit);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int upperLimit = Integer.parseInt(br.readLine());

            sb.append(binarySearch(upperLimit)).append("\n");
        }
        System.out.println(sb);
    }

    private static String binarySearch(int upperLimit) {

        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (upperLimit <= characters[mid].getUpperLimit()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int min = Math.min(left, right);
        int max = Math.max(left, right);

        if (min < 0) min = 0;
        if (max > (N - 1)) max = N - 1;

        if (upperLimit <= characters[min].getUpperLimit()) return characters[min].getStyle();
        else return characters[max].getStyle();
    }
}