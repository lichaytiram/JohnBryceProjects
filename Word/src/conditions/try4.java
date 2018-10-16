package conditions;

import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		if (x>=67)
			System.out.println("pensia");
		else {
			System.out.println(67-x+" will be in pensia");
		}

		scan.close();
	}
}
