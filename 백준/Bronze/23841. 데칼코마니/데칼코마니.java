import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		String[][] decalcomanie = new String[n][m];
		for (int i = 0; i < n; i++) {
			String str = scanner.next();
			String[] arr = str.split("");
			for (int j = 0; j < m; j++) {
				decalcomanie[i][j] = arr[j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!decalcomanie[i][j].equals(".")) {
					decalcomanie[i][m - 1 - j] = decalcomanie[i][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				System.out.print(decalcomanie[i][j]);
			System.out.println();
		}
		scanner.close();
	}
}