package page49;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = 0;
		int[][] matrix = new int[10][10];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] += x;
				x++;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
		}

		scan.close();
	}
}
