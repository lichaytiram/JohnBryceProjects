package page33;

import java.util.Scanner;

public class try18 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int amount = scan.nextInt(), max1 = 0, max2 = 0, countI = 0, countII = 0;
		for (int i = 1; i <= amount; i++) {
			int number = scan.nextInt();
			if (number > max1) {
				max2 = max1;
				max1 = number;
				countI = countII;
				countII = i;
			} else if (number >= max2) {
				max2 = number;
				countI = i;
			}
		}
		System.out.println(max2);
		System.out.println(countI);

		scan.close();
	}
}
