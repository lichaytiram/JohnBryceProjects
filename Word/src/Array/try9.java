package Array;

import java.util.Scanner;

public class try9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arrmin = new int[3];
		int[] arrmax = new int[5];
		System.out.println("Enter numbers for small array");
		for (int i = 0; i < arrmin.length; i++) {
			arrmin[i] = scan.nextInt();
		}
		System.out.println("Enter numbers for big array");
		for (int i = 0; i < arrmax.length; i++) {
			arrmax[i] = scan.nextInt();
		}
		int min = arrmax.length - 1, count = 0;
		boolean b = true;
		for (int i = 0; i < arrmin.length; i++) {
			if (count > arrmax.length - 1) {
				b = false;
				break;
			}
			if (arrmin[0] == arrmax[count])
				min = count;
			if (arrmin[i] == arrmax[count])
				count++;
			else
				while (arrmin[i] != arrmax[count]) {
					count++;
					if (count > arrmax.length - 1) {
						b = false;
						break;
					}
				}
		}
		if (b)
			System.out.println("The index is " + min);
		else
			System.out.println("The smaller array isn't inside ");

		scan.close();

	}
}
