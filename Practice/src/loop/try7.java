package loop;

import java.util.Scanner;

public class try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), temp = n1;
		for (int i = 1; i < n2; i++) {
			n1 *= temp;
		}
		System.out.println(n1);

		scan.close();
	}
}
