package Array;

import java.util.Scanner;

public class try10v2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] arr = new char[10];
		char[] arrFix = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.next().charAt(0);
		}
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			boolean see = true;
			for (int j = 0; j < arrFix.length; j++) {
				if (arr[i] == arrFix[j]) {
					see = false;
					break;
				}
				if (j == arr.length - 1)
					arrFix[i] = arr[i];
			}
			if (see) {
				int sum = 0;
				for (int j = 0; j < arr.length; j++) {
					if (arr[i] == arr[j])
						sum++;
				}
				System.out.println("-" + arrFix[i] + "- have " + sum + " times");
			}
		}
		scan.close();
	}
}
