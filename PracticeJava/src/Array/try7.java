package Array;

import java.util.Scanner;

public class try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] arr = new char[50];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.next().charAt(0);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int digit = 0, letters = 0, other = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= '9' && arr[i] >= '0')
				digit++;
			else if ((arr[i] <= 'z' && arr[i] >= 'a') || (arr[i] <= 'Z' && arr[i] >= 'A'))
				letters++;
			else
				other++;
		}

		System.out.println("\n"+"digit " + digit + " letters " + letters + " other " + other);
		scan.close();
	}
}
