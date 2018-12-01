package page51;

import java.util.Scanner;

public class try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sign = -1, top = 2;
		double sum = 0;
		int n = scan.nextInt(), x = scan.nextInt();

		for (int i = 1; i <= n; i++) {
			sum += sign * top(x, top) / factorial(i);
			top += 2;
			sign *= -1;
		}
		System.out.println(sum);
		scan.close();
	}

	public static int top(int x, int top) {
		int sum = 1;
		for (int i = 0; i < top; i++) {
			sum *= x;
		}
		return sum;
	}

	public static double factorial(int num) {
		int sum = 1;
		for (int i = 1; i <= num; i++) {
			sum *= i;
		}
		return sum;
	}
}
