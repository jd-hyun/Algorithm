import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int min = 0;
      int x = 0;
      int y = 0;
      if (n % 5 == 0)
    	  min = n / 5;
      Loop1 : for (int i = 1; i < n; i++) {
    	  for (int j = 1; j < n; j++) {
			if (3 * i + 5 * j == n) {
				x = i;
				y = j;
				break Loop1;
			}
    	  }
      }
      if (n % 5 == 0)
    	  min = n / 5;
      else if (x != 0 || y != 0)
    	  min = x + y;
      else if (n % 3 == 0)
    	  min = n / 3;
      else 
    	  min = -1;
      System.out.println(min);
      scanner.close(); 
    }
}