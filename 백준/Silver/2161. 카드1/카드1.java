import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (list.size() != 1) {
            System.out.print(list.get(0) + " ");
            list.remove(0);
            list.add(list.get(0));
            list.remove(0);
        }
        System.out.println(list.get(0));
        scanner.close();
    }
}