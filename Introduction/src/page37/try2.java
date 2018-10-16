package page37;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 100; i++) {
			int num = scan.nextInt();
			if (num == 0)
				System.out.println(1);
			else {
				int sum = 1;
				for (int j = 1; j <= num; j++) {
					sum *= j;
				}
				System.out.println(sum);
			}
		}
		scan.close();
	}
}
