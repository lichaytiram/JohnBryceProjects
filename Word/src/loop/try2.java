package loop;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), max = x, min = x;
		for (int i = 0; i < 99; i++) {
			x = scan.nextInt();
			if (x > max)
				max = x;
			if (x < min)
				min = x;
			
		}
		System.out.println(max + " < max and min > " + min);

		scan.close();
	}
}
