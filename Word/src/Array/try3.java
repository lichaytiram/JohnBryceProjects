package Array;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			sum += arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			if (sum - arr[i] == arr[i])
				System.out.println(i);

		}

		scan.close();
	}
}
