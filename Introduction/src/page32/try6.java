package page32;

import java.util.Scanner;

public class try6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), sum = 0, ex = 0;
		for (int i = 1; i <= n; i++) {
			int temp = 0;
			for (int j = 0; j <= ex; j++) {
				temp *= 2;

			}
			sum += temp;
			ex++;

		}

		System.out.println(sum);

		scan.close();
	}
}
