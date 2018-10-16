package page49;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = new int[9][9];
		int count1 = 0, count2 = matrix.length - 1;
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix.length; j++) {
				if (j == count1 || j == count2)
					System.out.print("1");
				else
					System.out.print("0");

			}
			count1++;
			count2--;
		}

		scan.close();
	}
}