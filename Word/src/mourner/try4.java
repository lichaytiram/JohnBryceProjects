package mourner;

import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), n3 = scan.nextInt();
		if ((n1 + n2) < n3)
			System.out.println("can't");
		else if ((n1 + n3) < n2)
			System.out.println("can't");
		else if ((n2 + n3) < n1)
			System.out.println("can't");
		else
			System.out.println("yes they can");
		scan.close();
	}
}
