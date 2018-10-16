package loop;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int x = scan.nextInt();
			sum += x;
		}
		System.out.println(sum / 10);

		scan.close();
	}
}
