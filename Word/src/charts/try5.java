package charts;

import java.util.Scanner;

public class try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), y = scan.nextInt(), z = x;
		System.out.println(x + " " + y);
		x = y;
		y = z;
		System.out.println(x + " " + y);

		scan.close();
	}
}
