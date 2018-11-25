package LoopNested;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), y = scan.nextInt();
		for (int i = 1; i <= x; i++) {
			System.out.println();
			for (int j = 1; j <= y; j++) {
				System.out.print(j * i+" ");
			}
		}

		scan.close();
	}
}
