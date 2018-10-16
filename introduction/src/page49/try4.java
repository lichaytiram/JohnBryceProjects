package page49;

import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = new int[10][10];
		char s =scan.next().charAt(0);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix.length; j++) {
				if(j*i%5==0 || j*i%7==0)
					System.out.print("0");
				else
					System.out.print(s);
			}
		}
		
		scan.close();
	}
}