package page26;

import java.util.Scanner;

public class try21 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = 1, n2 = 1, num = scan.nextInt();
		for (int i = 2; i <num; i++) {
			if(n1<=n2)
				n1+=n2;
			else
				n2+=n1;
		}
		if(n1>n2)
			System.out.println(n1);
		else
			System.out.println(n2);

		scan.close();

	}

}
