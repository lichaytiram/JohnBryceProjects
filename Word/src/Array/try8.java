package Array;

import java.util.Scanner;

public class try8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		int count = arr.length - 1;
		boolean t = false;
		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] == arr[count]) {
				count--;
				t = true;
			} else {
				System.out.println("The number isn't polindrom");
				t = false;
				break;
			}
		}

		if (t)
			System.out.println("The number is polindrom");

		scan.close();
	}
}
