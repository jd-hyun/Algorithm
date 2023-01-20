import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String title = scanner.next();
            if (map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            } else {
                map.put(title, 1);
            }
        }

        int count = 0;
        String answer = "";
        for (String key : map.keySet()) {
            if (map.get(key) >= count) {
                count = map.get(key);
                answer = key;
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == count && key.compareTo(answer) < 0) {
                answer = key;
            }
        }
        System.out.println(answer);
        scanner.close();

    }
}