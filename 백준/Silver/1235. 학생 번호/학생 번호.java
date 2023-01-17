import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        Set<String> set = new HashSet<>();
        int k = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        int index = arr[0].length() - 1;
        for (int i = index; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                set.add(arr[j].substring(i));
            }
            if (set.size() == n) break;
            set.clear();
            k++;
        }
        System.out.println(k);
        scanner.close();
    }
}