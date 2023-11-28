import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
		for (int i = 0 ; i < 100; i++) {
			for (int j = i; j < 100 - i; j++) {
				int sum = i + j;
				if (arr[i / 10] + arr[i % 10] + arr[j / 10] + arr[j % 10] + arr[sum / 10] + arr[sum % 10] == n - 4) {
					System.out.println("" + i / 10 + i % 10 + "+" + j / 10 + j % 10 + "=" + sum / 10 + sum % 10);
					return;
				}
			}
		}
		System.out.println("impossible");
		scanner.close();
	}
}