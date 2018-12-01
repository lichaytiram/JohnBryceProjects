import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		int[][] arr = new int[3][5];
		inside(arr);
		int sum = sum1(arr, 0);
		boolean check = sumAll(arr, sum);
		if (check == false)
			System.out.println("This isn't even for all numbers"+"\n"+"false");
		else
			System.out.print(evenAll(arr));

	}

	public static void inside(int[][] arr) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter a numbers for arr " + (i + 1));
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();
	}

	public static int sum1(int[][] arr, int x) {
		int sum = 0;
		if (arr[0].length % 2 != 0)
			sum += arr[0][arr[0].length / 2];

		for (int i = 0; i < arr[0].length; i++) {
			sum += arr[0][i];
		}
		return sum;
	}

	public static boolean sumAll(int[][] arr, int sum) {
		boolean sumF = true;
		int sumAll = 0;
		if (arr[arr.length - 1].length % 2 != 0)
			sumAll += arr[arr.length - 1][arr[arr.length - 1].length / 2];
		for (int i = 0; i < arr[arr.length - 1].length; i++) {
			sumAll += arr[arr.length - 1][i];
		}
		if (sum != sumAll)
			sumF = false;
		return sumF;
	}

	public static boolean evenAll(int[][] arr) {
		boolean check = true;
		for (int i = 0; i < arr.length; i++) {
			int length = arr[i].length - 1;
			for (int j = 0; j < arr[i].length / 2; j++) {
				if (arr[i][j] != arr[i][length]) {
					check = false;
					break;
				}
				length--;
			}
			if (check == false)
				break;
		}
		if (check == true)
			System.out.println("This is even numbers");
		else
			System.out.println("Only sum is even but digits isn't");
		return check;
	}
}
