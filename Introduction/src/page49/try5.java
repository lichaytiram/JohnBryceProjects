package page49;

import java.util.Scanner;

public class try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0, start = 0, end = 0; // sum number for check ,else sum x
		boolean check = true;
		int[][] matrix = new int[3][3];
		int startC = 0, endC = matrix.length-1; // check x count
		int[] jCheck = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = scan.nextInt();
				if (i == 0)
					sum += matrix[i][j];
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			int sumcheck = 0;
			for (int j = 0; j < matrix.length; j++) {
				sumcheck += matrix[i][j];
				jCheck[j] += matrix[i][j];
				if (j == startC)
					start += matrix[i][j];

				if (j == endC)
					end += matrix[i][j];

			}
			startC++;
			endC--;
			if (i == matrix.length - 1) {
				if (sum != jCheck[i]) {
					System.out.println("Isn't magic square!");
					check = false;
					break;
				}
				if (start != sum || end != sum) {
					System.out.println("Isn't magic square!");
					check = false;
					break;
				}
			}

			if (sum != sumcheck) {
				System.out.println("Isn't magic square!");
				check = false;
				break;
			}
		}

		if (check)
			System.out.println("This is a magic square");
		scan.close();
	}
}