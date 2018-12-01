package LabGuidePage7;

import java.util.Scanner;

public class ex6try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = (int) (Math.random() * 16),sum=1;
		System.out.println("you number is "+x);
		for(int i=2;i<=x;i++) {
			sum*=i;
		}
		System.out.println("your factorial is "+sum);
		
		
		scan.close();
	}
}
