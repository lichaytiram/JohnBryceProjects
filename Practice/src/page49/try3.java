package page49;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int summax = 0, index = 0;
		int[][] matrix = new int[10][10];
		for (int i = 0; i < matrix.length; i++) {
			int sum = 0;
			for (int j = 0; j < matrix.length; j++) {
				int num = scan.nextInt();
				sum += num;
			}
			if (sum > summax) {
				summax = sum;
				index = i;
			}
		}
		System.out.println(index);

		scan.close();
	}
}