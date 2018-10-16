package page8;

import java.util.Scanner;

public class ex7try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[50];
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) (Math.random() * 101);
		int max = 0, index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		System.out.println("The max number is " + max + " and his index is " + index);
		scan.close();
	}
}