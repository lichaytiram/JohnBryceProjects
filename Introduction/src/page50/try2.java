package page50;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		first(n1);
		second(n1);
		triple(n1);
		scan.close();
	}

	public static void first(int n1) {
		for (int i = 1; i <= n1; i++) {
			System.out.println();
			for (int j = 0; j < i; j++) {
				System.out.print(n1 - j);
			}
		}
	}

	public static void second(int n1) {

		for (int i = 1; i < n1 - 1; i++) {
			System.out.println();
			for (int j = n1 - i; j > 0; j--) {
				System.out.print(j);
			}
		}
	}

	public static void triple(int n1) {
		for (int i = 0; i < n1; i++) {
			System.out.println();
			for (int j = 1; j <= i + 1; j++) {
				System.out.print(j);
			}
		}
	}
}
