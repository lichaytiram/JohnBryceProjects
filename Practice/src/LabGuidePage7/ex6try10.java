package LabGuidePage7;

import java.util.Scanner;

public class ex6try10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 100; i++) {
			if (i % 7 == 0 || i % 10 == 7 ||i/10==7) {
				System.out.println("Boom");
			} else
				System.out.println(i);
		}

		scan.close();
	}
}
