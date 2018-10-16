package page33;

import java.util.Scanner;

public class try19 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), rn = n + 1, f1 = 1, f2 = 1, temp = 0;
		for (int i = 3; i <= rn; i++) {
			if (f1 < f2) {
				temp = f2 + f1;
				f1 = temp;
			} else {
				temp = f2 + f1;
				f2 = temp;

			}
		}
		if (f1 > f2)
			System.out.println(f1);
		else
			System.out.println(f2);
		scan.close();

	}
}
