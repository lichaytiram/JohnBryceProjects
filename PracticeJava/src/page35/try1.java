package page35;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), temp = x;
		for (int i = 0; i < 9; i++) {
			if (x == temp || x == temp + 1) {
				temp = x;
				x = scan.nextInt();
			} else {
				System.out.println("not sort");
				break;
			}
			if (i == 8)
				System.out.println("sort");

		}

		scan.close();
	}
}
