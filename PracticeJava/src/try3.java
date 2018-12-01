import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), n1C = checkHowMuch(n1), n2C = checkHowMuch(n2);
		if (n1C != n2C)
			System.out.println("-1");
		else {
			int[] arrn1 = new int[n1C];
			int[] arrn2 = new int[n2C];
			int[] arrmax = new int[n1C];
			putInside(arrn1, n1);
			putInside(arrn2, n2);
			max(arrmax, arrn1, arrn2);
			print(arrmax);
		}
		scan.close();
	}

	public static int checkHowMuch(int num) {
		int count = 0;
		while (num > 0) {
			count++;
			num /= 10;
		}
		return count;
	}

	public static void putInside(int[] arr, int num) {
		int place = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			arr[place] = num % 10;
			num /= 10;
			place--;
		}
	}

	public static void max(int[] max, int[] n1, int[] n2) {
		for (int i = 0; i < max.length; i++) {
			if (n1[i] < n2[i])
				max[i] = n1[i];
			else
				max[i] = n2[i];
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);

		}
	}
}
