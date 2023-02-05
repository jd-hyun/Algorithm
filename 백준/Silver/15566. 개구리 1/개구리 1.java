import java.util.*;

public class Main {
    static int n, m;
    static int[][] interest, preference, way;
    static int[] flowers;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        interest = new int[n][4];
        preference = new int[n][2];
        way = new int[m][3];
        flowers = new int[n];
        Arrays.fill(flowers, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                interest[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            preference[i][0] = scanner.nextInt();
            preference[i][1] = scanner.nextInt();
            if (preference[i][0] == preference[i][1]) {
                preference[i][1] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                way[i][j] = scanner.nextInt();
            }
        }

        if (dfs(0)) {
            System.out.println("YES");
            for (int flower : flowers) {
                System.out.print(flower + 1 + " ");
            }
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }

    private static boolean dfs(int index) {
        if (index == n) {
            if (check()) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < 2; i++) {
            if (preference[index][i] == -1) continue;
            int i1 = preference[index][i] - 1;
            if (flowers[i1] == -1) {
                flowers[i1] = index;
                if (dfs(index + 1)) {
                    return true;
                }
                flowers[i1] = -1;
            }
        }
        return false;
    }

    private static boolean check() {
        for (int i = 0; i < m; i++) {
            int i1 = way[i][0] - 1;
            int i2 = way[i][1] - 1;
            int i3 = way[i][2] - 1;
            if (interest[flowers[i1]][i3] != interest[flowers[i2]][i3]) {
                return false;
            }
        }
        return true;
    }
}