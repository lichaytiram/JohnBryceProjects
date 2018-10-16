package loop;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), max = x, min = x, indexmax = 1, indexmin = 1;
		for (int i = 2; i <= 5; i++) {
			x = scan.nextInt();
			if (x > max) {
				max = x;
				indexmax = i;
			}
			if (x < min) {
				min = x;
				indexmin = i;
			}
		}
		System.out.println(max + " " + indexmax + " < max and min > " + min + " " + indexmin);

		scan.close();
	}
}
