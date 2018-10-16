package conditions;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(),y=scan.nextInt();
		if (x==y)
			System.out.println("even");
		else
			System.out.println("not even");

		scan.close();
	}
}
