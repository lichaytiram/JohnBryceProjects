package page50;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a length");
		int[][] arr = new int[scan.nextInt()][scan.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 0 || i == 0 || i == arr.length - 1 || arr[i].length - 1 == j)
					System.out.print("# ");
				else
					System.out.print("~ ");
			}
		}
		scan.close();
	}
}
