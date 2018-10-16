package page38;

import java.util.Scanner;

public class try8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sur = scan.nextInt(), amu = scan.nextInt();
		for (int i = 0; i < sur; i++) {
			System.out.println("");
			for (int j = 0; j < amu; j++)
				System.out.print("*");
		}

		scan.close();
	}
}
