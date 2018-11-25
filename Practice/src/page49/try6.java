package page49;

import java.util.Scanner;

public class try6 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr1 = new int[10][10];
		int[][] arr2 = new int[40][40];
		boolean check = true;
		System.out.println("Enter random digids for arr1");
		Jdata(arr1);
		System.out.println("Enter random digids for arr2");
		Jdata(arr2);
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				boolean inCheck = false;
				for (int k = 0; k < arr2.length; k++) {
					for (int k2 = 0; k2 < arr2[k].length; k2++) {
						if (arr1[i][j] == arr2[k][k2]) {
							inCheck = true;
							break;
						}

					}
					if (inCheck == true)
						break;
					if (k == arr2.length - 1 && inCheck == false)
						check = false;
				}
				if (check == false)
					break;

			}
			if (check == false)
				break;
		}
		if (check)
			System.out.println("All array is Containe inside");
		else
			System.out.println("Isn't Containe!");
	}

	public static int[][] Jdata(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		return arr;
	}
}
