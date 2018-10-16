package page35;

import java.util.Scanner;

public class try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum1 = 0, sum2 = 0, sum3 = 0;
		for (int i = 0; i < 1000; i++) {
			int x = scan.nextInt();
			if (x < 1000 && x > 0)
				sum1 += x;
			else if (x < 2000 && x >= 1000)
				sum2 += x;
			else
				sum3 += x;
		}
		System.out.println("sum1 " + sum1 + " sum2 " + sum2 + " sum3 " + sum3);

		scan.close();
	}
}
