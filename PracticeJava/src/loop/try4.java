package loop;

import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), sum = 0;
		for (int i = 0; i < n1; i++) {
			sum += n2;
		}
		System.out.println(sum);

		scan.close();
	}
}
