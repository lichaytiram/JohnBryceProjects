package conditions;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		if (x <0)
			System.out.println(x*-1);
		else
			System.out.println(x);

		scan.close();
	}
}
