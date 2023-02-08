import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
                if (i == n - 1) list.add(arr[i][j]);
            }
        }

        Collections.sort(list);
        Collections.reverse(list);


        for (int i = n - 2; i >= 0 ; i--) {
            for (int j = 0; j < n; j++) {
                if (list.get(n - 1) < arr[i][j]) {
                    for (int k = 0; k < n; k++) {
                        if (list.get(k) < arr[i][j]) {
                            list.add(k, arr[i][j]);
                            list.remove(n);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(list.get(n - 1));
        scanner.close();
    }
}