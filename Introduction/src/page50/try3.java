package page50;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int entire = scan.nextInt(), check = 1;
		while (check <= entire) {
			triangular(check);
			check++;
		}

		scan.close();
	}

	public static void triangular(int entire) {
		for (int i = 0; i < entire; i++) {
			System.out.println();
			for (int j = i; j < entire; j++) {
				System.out.print(entire);
			}
		}
	}

}
