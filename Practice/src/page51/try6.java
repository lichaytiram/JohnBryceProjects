package page51;

import java.util.Scanner;

public class try6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), count = 0;
		int[] arrtemp = new int[count];
		int[] arr = new int[count];
		while (x > 0) {
			count++;
			arr = new int[count];
			arr[count - 1] = x;
			copyArr(arrtemp, arr);
			arrtemp = new int[count];
			copyArr(arr, arrtemp);
			x = scan.nextInt();
		}

		for (int i = 0; i < arr.length; i++)
			System.out.print(" number " + (i + 1) + "-> " + arr[i]);

		System.out.println();
		int max = 1, maxnumber = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > maxnumber)
				maxnumber = arr[i];
		int loop=maxnumber;

		for (int i = 0; i < loop; i++) {
			boolean check = true;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] % maxnumber != 0) {
					maxnumber--;
					check = false;
					break;
				}
			}
			if (check == true) {
				max = maxnumber;
				break;
			}
		}

		System.out.println("The max number is " + max);
		scan.close();
	}

	public static void copyArr(int[] arrBoth, int[] arrC) {
		for (int i = 0; i < arrBoth.length; i++) {
			arrC[i] = arrBoth[i];
		}
	}
}
