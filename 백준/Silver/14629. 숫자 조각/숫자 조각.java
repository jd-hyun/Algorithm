import java.util.*;

public class Main {
    static Long min = 9876543210L;
    static String result = "";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean[] numbers = {false, false, false, false, false, false, false, false, false, false};
        String n = scanner.next();
        Long num = Long.parseLong(n);

        if (num >= min || n.length() > 10) {
            System.out.println("9876543210");
        } else {
            int length = n.length();

            dfs(numbers, 0, "", length, num);
            if (length != 1)
                dfs(numbers, 0, "", length - 1, num);
            if (length != 10) {
                dfs(numbers, 0, "", length + 1, num);
            }

            System.out.println(Long.parseLong(result));
        }
        scanner.close();
    }

    private static void dfs(boolean[] numbers, int index, String s, int length, Long num) {

        if (index == length) {
            Long tmp = Math.abs(Long.parseLong(s) - num);
            if (tmp < min) {
                min = tmp;
                result = s;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!numbers[i]) {
                numbers[i] = true;
                dfs(numbers, index + 1, s + i, length, num);
                numbers[i] = false;
            }
        }
    }
}
