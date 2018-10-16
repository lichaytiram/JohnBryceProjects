package page27;

import java.util.Scanner;

public class try26 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), max = 0;
		if (n1 > n2)
			max = n1;
		else {
			max = n2;
			n2 = n1;
		}
		for(int i=n2;i<=max;i++) {
			System.out.println(i);
		}
		scan.close();
	}
}
