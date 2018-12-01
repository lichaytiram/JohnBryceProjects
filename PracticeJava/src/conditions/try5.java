package conditions;

import java.util.Scanner;

public class try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int howmuch = scan.nextInt(), money = scan.nextInt(), sum = 0;
		sum = howmuch * money;
		System.out.println(sum);
		if (sum > 500)
			System.out.println("patpetan");

		scan.close();
	}
}
