package page33;

import java.util.Scanner;

public class try17 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt(), max = 0, index = 0, sum = 1;
		for (int i = 1; i <= count; i++) {
			int num = scan.nextInt();
			if (num > max) {
				max = num;
				index = i;
				sum = 1;
			} else if (num == max)
				sum++;
		}

		System.out.println(max + " Index " + index + " numbers " + sum);

		scan.close();
	}
}
