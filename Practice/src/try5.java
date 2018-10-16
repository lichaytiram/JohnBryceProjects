import java.util.Scanner;

public class try5 {

	public static void main(String[] args) {
		int[] arr = new int[4];
		inside(arr);
		print(arr);
	}

	public static void inside(int[] arr) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Number " + arr[i]);
			while (arr[i] > 0) {
				System.out.print("*");
				arr[i] -= 1;
			}
			System.out.println();
		}

	}
}
