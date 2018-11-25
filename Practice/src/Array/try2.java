package Array;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0, count = 0;
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			if (arr[i] % 2 == 0) {
				sum += arr[i];
				count++;
			}
		}
		if (count == 0)
			System.out.println("no avarage");
		else
			System.out.println(sum / count);
		scan.close();
	}
}
