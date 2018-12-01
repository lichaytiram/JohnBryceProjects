package LabGuidePage7;

import java.util.Scanner;

public class ex6try8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = (int) (Math.random() * 51),f1=1,f2=1;
		System.out.println("Your number is "+ x);
		System.out.println("first number is "+"\n"+"1"+"\n"+"1");
		for(int i=3;i<=x;i++) {
			f1+=f2;
			f2=f1-f2;
			System.out.println(f1);
		}
		System.out.println("Fiboncci is "+f1);
		
		scan.close();
	}
}
