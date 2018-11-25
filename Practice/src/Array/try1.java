package Array;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int average = 0;
		int[] arr = new int[50];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			average += arr[i];
		}
		average /= 50;
		System.out.println(average);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > average) {
				System.out.println("The numbers bigger then average is " + arr[i]);
			}
		}

		scan.close();
	}
}
