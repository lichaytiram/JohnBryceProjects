package Array;

import java.util.Scanner;

public class try8v2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		int count = arr.length - 1;
		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] != arr[count]) {
				System.out.print("not ");
				break;
			}else
				count--;
		}
		
		System.out.println("polindrom");
		scan.close();
	}
}
