package LabGuidePage8;

import java.util.Scanner;

public class ex7try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		int[] arrs = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 11);
			arrs[i] = -1;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		int arr2size = 0, count = 0; // number inside array
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arrs.length; j++) {
				if (arr[i] == arrs[j])
					break;
				if (arrs.length - 1 == j) {
					arrs[count] = arr[i];
					count++;
					arr2size++;
				}

			}
		}

		int[] arr2 = new int[arr2size];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arrs[i];
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		scan.close();
	}
}