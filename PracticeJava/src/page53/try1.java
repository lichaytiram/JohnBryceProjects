package page53;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), max1 = 0, max2 = 0, max3 = 0, max1C = 0, max2C = 0, max3C = 0;
		while (x != -1) {
			if (countZ(x) > max1C) {
				max3C = max2C;
				max2C = max1C;
				max1C = countZ(x);
				max3 = max2;
				max2 = max1;
				max1 = x;
			} else if (countZ(x) > max2C) {
				max3C = max2C;
				max2C = countZ(x);
				max3 = max2;
				max2 = x;
			} else if (countZ(x) > max3C) {
				max3C = countZ(x);
				max3 = x;
			}
			x = scan.nextInt();
		}
		System.out.println("max numbers is " + max1 + " " + max2 + " " + max3);
		scan.close();
	}

	public static int countZ(int num) {
		int countTime = 0;
		while (num > 0) {
			if ((num % 10) % 2 == 0 || num % 10 == 0)
				countTime++;
			num /= 10;
		}
		return countTime;
	}
}
