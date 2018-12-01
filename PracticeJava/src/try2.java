import java.util.Scanner;

public class try2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		oneMore(num);
		System.out.println();
		fix(num);
		scan.close();
	}

	public static void oneMore(int x) {
		int count = 0, temp = x;
		while (temp > 0) {
			count++;
			temp /= 10;
		}
		if (count == 0)
			count = 1;

		for (int i = 0; i < count; i++) {
			temp = x;
			int check = (int) Math.pow(10, count - 1 - i);
			temp /= check;
			if (temp % 10 == 9)
				System.out.print(0);
			else
				System.out.print(temp % 10 + 1);

		}
	}

	public static void fix(int x) {
		int count = 0, temp = x;
		while (temp > 0) {
			count++;
			temp /= 10;
		}
		if (count == 0)
			count = 1;
		int[] arr = new int[count];
		for (int i = 0; i < arr.length; i++) {
			arr[arr.length - i - 1] = x % 10;
			x /= 10;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 9)
				System.out.print("0");
			else
				System.out.print(arr[i] + 1);
		}

	}

}
