package page35;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 365; i++) {
			int x = scan.nextInt();
			if (x > 40 || x < -5) {
				System.out.println("fail data");
				break;
			}
			if (i == 364)
				System.out.println("good data");

		}

		scan.close();
	}
}
