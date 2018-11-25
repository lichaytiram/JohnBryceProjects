package page38;

import java.util.Scanner;

public class try10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt();
		for (int i = 1; i <= n1; i++) {
			System.out.println();
			for (int j = 1; j <= n2; j++) {
				System.out.print(j * i);
			}
		}

		scan.close();
	}
}
