package conditions;

import java.util.Scanner;

public class try10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(),n2 = scan.nextInt(),n3 = scan.nextInt();
		if(n1>n2 && n1>n3)
			System.out.println(n1);
		if(n2>n1 && n2>n3)
			System.out.println(n2);
		if(n3>n2 && n3>n1)
			System.out.println(n3);
		
		scan.close();
	}
}
