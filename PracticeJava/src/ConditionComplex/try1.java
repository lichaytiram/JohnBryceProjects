package ConditionComplex;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), n3 = scan.nextInt();
		if (n1 == n2 && n1 == n3)
			System.out.println("meshulash shve zlaot");
		else if (n1 == n2 || n1 == n3 || n2 == n3)
			System.out.println("meshulash shve shokaim");
		else if (Math.sqrt(Math.pow(n1, 2) + Math.pow(n2, 2)) == n3
				|| Math.sqrt(Math.pow(n1, 2) + Math.pow(n3, 2)) == n2
				|| Math.sqrt(Math.pow(n2, 2) + Math.pow(n3, 2)) == n1)
			System.out.println("meshulash yashar zavit");
		else
			System.out.println("regular");
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
