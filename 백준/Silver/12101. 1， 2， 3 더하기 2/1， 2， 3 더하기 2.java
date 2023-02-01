import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<String>[] arr = new ArrayList[n + 2];

        for (int i = 0; i < n + 2; i++) {
            arr[i] = new ArrayList<>();
        }

        arr[0].add("1");
        arr[1].add("1+1");
        arr[1].add("2");
        arr[2].add("1+1+1");
        arr[2].add("1+2");
        arr[2].add("2+1");
        arr[2].add("3");

        for (int i = 3; i < n; i++) {
            for (int j = 1; j < 4; j++) {
                for (String s : arr[i - j]) {
                    arr[i].add(s + "+" + j);
                }
            }
        }

        if (arr[n - 1].size() < k) {
            System.out.println(-1);
        } else {
            Collections.sort(arr[n - 1]);
            System.out.println(arr[n - 1].get(k - 1));
        }

        scanner.close();
    }
}