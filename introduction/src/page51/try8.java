package page51;

import java.util.Scanner;

public class try8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(), sum = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0)
				sum += i;
		}
		if (sum == num)
			System.out.println("This is a perfect number!!");
		else
			System.out.println("This isn't a perfect number");

		scan.close();
	}
}
