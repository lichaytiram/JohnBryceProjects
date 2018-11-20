package LabGuidePage6;

import java.util.Scanner;

public class ex5try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = (int) (Math.random() * 3000);
		if (x % 4 == 0 || x % 100 != 0 || (x % 100 == 0 && x % 400 == 0))
			System.out.println("leap");

		scan.close();
	}
}
