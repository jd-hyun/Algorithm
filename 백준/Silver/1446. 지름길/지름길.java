import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        Shortcut[] shortcuts = new Shortcut[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            shortcuts[i] = new Shortcut(start, end, d);
        }

        Arrays.sort(shortcuts, new Comparator<Shortcut>() {
            @Override
            public int compare(Shortcut o1, Shortcut o2) {
                return o1.getStart() - o2.getStart();
            }
        });

        int[] dp = new int[D + 1];

        for (int i = 1; i <= D; i++) {
            dp[i] = dp[i - 1] + 1;
        }

        for (Shortcut shortcut : shortcuts) {
            if (shortcut.getStart() > D || shortcut.getEnd() > D) continue;
            if (shortcut.getEnd() - shortcut.getStart() > shortcut.getD()) {
                if (dp[shortcut.getEnd()] > (dp[shortcut.getStart()] + shortcut.getD())) {
                    dp[shortcut.getEnd()] = dp[shortcut.getStart()] + shortcut.getD();
                    for (int i = shortcut.getEnd() + 1; i <= D; i++) {
                        dp[i] = Math.min(dp[i], dp[i - 1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[D]);
    }
}

class Shortcut {
    private int start;

    private int end;

    private int d;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getD() {
        return d;
    }

    public Shortcut(int start, int end, int d) {
        this.start = start;
        this.end = end;
        this.d = d;
    }
}