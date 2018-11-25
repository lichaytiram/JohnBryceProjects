package page35;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x, sum = 0;
		for (int i = 0; i < 1000; i++) {
			x = scan.nextInt();
			if (x == sum) {
				System.out.println(x);
				break;
			}
			sum += x;
			if (i == 999)
				System.out.println("isn't found");
		}
		scan.close();
	}
}
