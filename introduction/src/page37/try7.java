package page37;

import java.util.Scanner;

public class try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = 0;
		for (int i = 0; i < 10; i++) {
			int n = scan.nextInt();
			if (i > 0) {
				if (n > x) {
					for (int d = x; d <= n; d++)
						System.out.print(d);
				} else {
					for (int d = x; d >= n; d--)
						System.out.print(d);
				}

			}
			x = n;
		}

		scan.close();
	}
}
