package Array;

import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int temp;
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();

		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[i + 10];
			arr[i + 10] = temp;
		}
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");

		scan.close();
	}
}
