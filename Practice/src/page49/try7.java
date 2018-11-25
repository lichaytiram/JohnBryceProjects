package page49;

import java.util.Scanner;

public class try7 {
	public static void main(String[] args) {
		int[][] arr = new int[30][10];
		input(arr);
		average(arr);

	}

	public static void input(int[][] arr) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();
	}

	public static void average(int[][] arr) {
		int summax = 0, best = 0;
		int[] profession = new int[arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
				profession[j] += arr[i][j];
			}
			sum /= arr[0].length;
			System.out.println("Student " + (i + 1) + " average is " + sum);
			if (sum > summax) {
				summax = sum;
				best = i + 1;
			}

		}
		for (int j = 0; j < profession.length; j++) {
			profession[j] /= arr.length;
		}

		int min = profession[0], minP = 0;
		for (int j = 0; j < profession.length; j++) {
			System.out.println("The sum of profession number " + (j + 1) + " is " + profession[j]);
			if (profession[j] <= min) {
				min = profession[j];
				minP = j + 1;
			}
		}
		System.out.println("The fail profession is " + minP);
		System.out.println("Best student is " + best + " ,and his average is " + summax);

	}

}
