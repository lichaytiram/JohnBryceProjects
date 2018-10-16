package ConditionComplex;

import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=scan.nextInt();
		while(x<=0)
			x=scan.nextInt();
		if(x<=55)
			System.out.println("Fail");
		else if(x<=70)
			System.out.println("low");
		else if(x<=84)
			System.out.println("medium");
		else if(x<=90)
			System.out.println("good");
		else
			System.out.println("perfect");
		
		
		scan.close();
	}
}
