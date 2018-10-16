package page29;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int entire = scan.nextInt();
		while (entire > 0) {
			int sum = 0;
			while (entire > 0) {
				sum += entire % 10;
				entire /= 10;
			}
			System.out.println(sum);
			entire = scan.nextInt();
		}
		scan.close();
	}
}
