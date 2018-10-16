package Array;

import java.util.Scanner;

public class try5v2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] arr = new int[60];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		int temp, count = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			while (arr[count] % 2 == 0) {
				if (count == i)
					break;
				count--;
			}
			if (count == i)
				break;
			if (arr[i] % 2 == 0) {
				temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
			}
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		scan.close();
	}
}
