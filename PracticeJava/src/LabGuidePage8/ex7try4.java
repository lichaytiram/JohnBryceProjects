package LabGuidePage8;

import java.util.Scanner;

public class ex7try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) (Math.random() * 11);

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
		reverse(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		scan.close();
	}

	public static int[] reverse(int[] arr) {
		int temp;
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;

		}
		return arr;
	}

}
