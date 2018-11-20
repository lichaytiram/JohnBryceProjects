package LabGuidePage5;

import java.util.Scanner;

public class ex5try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=(int)(Math.random()*101);
		if(x>50)
			System.out.println("Big");
		else if(x==50)
			System.out.println("Bingo");
		else
			System.out.println("Small");
		scan.close();
	}
}
