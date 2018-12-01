package page51;

import java.util.Scanner;

public class try9 {
	public static void main(String[] args) {
		int[] id = new int[9];
		in(id);
		if (sumAll(id) == id[id.length - 1])
			System.out.println("That ID is real <(^_^)>");
		else
			System.out.println("That ID isn't real!!! \nThe real last number is " + sumAll(id));
	}

	public static void in(int[] arr) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		x2(arr);

	}

	public static void x2(int[] arr) {
		for (int i = 1; i < arr.length; i++)
			if (i % 2 == 0)
				arr[i - 1] *= 2;
		sum(arr);

	}

	public static void sum(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > 9) {
				int temp = arr[i];
				temp /= 10;
				arr[i] = arr[i] % 10 + temp;
			}
	}

	public static int sumAll(int[] arr) {
		int sum = 0, x;
		for (int i = 0; i < arr.length - 1; i++) {
			sum += arr[i];
		}
		x = 100 - sum;
		return x % 10;
	}
}
