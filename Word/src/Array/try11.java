package Array;

import java.util.Scanner;

public class try11 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[5];
		System.out.println("Enter a sigh +/-");
		char sign = scan.next().charAt(0);
		while (sign != '-' && sign != '+')
			sign = scan.next().charAt(0);
		System.out.println("Thanks for sigh \nnow please enter a numbers for array");
		scanArr(arr, scan);
		move(arr, sign);
		scan.close();
	}

	public static void scanArr(int[] arr, Scanner scan) {
		System.out.println();
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		showArr(arr);
	}

	public static void showArr(int[] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static void move(int[] arr, char sigh) {
		if (sigh == '-') {
			int temp = arr[0];
			for (int i = 0; i < arr.length - 1; i++)
				arr[i] = arr[i + 1];

			arr[arr.length - 1] = temp;
		} else {
			int temp = arr[arr.length - 1];
			for (int i = arr.length - 2; i >= 0; i--)
				arr[i + 1] = arr[i];
			arr[0] = temp;
		}
		showArr(arr);
	}

}
