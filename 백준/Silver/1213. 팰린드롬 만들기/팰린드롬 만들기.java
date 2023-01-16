import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split("");
        int length = split.length;
        String[] answer = new String[length];
        Arrays.sort(split);

        int index = 0;
        if (length % 2 == 0) {
            for (int i = 0; i < length; i += 2) {
                if (!split[i].equals(split[i + 1])) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                answer[index] = split[i];
                answer[length - index - 1] = split[i];
                index++;
            }
        } else {
            int count = 0;
            for (int i = 0; i < length; i += 2) {
                if (i == length - 1) {
                    answer[length / 2] = split[i];
                    break;
                }
                if (!split[i].equals(split[i + 1])) {
                    if (count != 0) {
                        System.out.println("I'm Sorry Hansoo");
                        return;
                    }
                    count++;
                    answer[length / 2] = split[i--];
                    continue;
                }
                answer[index] = split[i];
                answer[length - index - 1] = split[i];
                index++;
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(answer[i]);
        }
        scanner.close();
    }
}