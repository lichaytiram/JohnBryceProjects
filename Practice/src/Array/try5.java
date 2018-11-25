package Array;

import java.util.Scanner;

public class try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[60];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();

		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		int temp, count = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {

			while (arr[count] % 2 == 0) {
				count--;
				if (count == 0)
					break;
			}
			if (i >= count)
				break;
			if (arr[i] % 2 == 0) {
				temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count--;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		scan.close();
	}
}
