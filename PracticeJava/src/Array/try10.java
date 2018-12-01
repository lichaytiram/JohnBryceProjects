package Array;

import java.util.Scanner;

public class try10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] arr = new char[5];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.next().charAt(0);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j])
					sum++;
			}
			System.out.println("The char number " + i + " show " + sum + " times");
		}

		scan.close();
	}
}
