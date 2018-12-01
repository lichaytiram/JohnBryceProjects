import java.util.Scanner;

public class try6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char c = scan.next().charAt(0);
		System.out.println("Your char is " + c);
		int[][] arr = new int[5][5];
		inside(arr, scan);
		showInfo(arr);
		/* not finish by bug */

		scan.close();
	}

	public static void inside(int[][] arr, Scanner scan) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scan.next().charAt(0);
			}
		}
	}

	public static void showInfo(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
