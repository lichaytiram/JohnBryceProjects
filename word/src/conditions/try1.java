package conditions;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		if (x % 2 == 0)
			System.out.println("zugi");
		else
			System.out.println("not zugi");

		scan.close();
	}
}
