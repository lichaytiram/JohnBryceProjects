package ConditionComplex;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char x=scan.next().charAt(0);
		System.out.println(x);
		if(x>='0' && x<='9')
			System.out.println("yes");
		
		scan.close();
	}
}

