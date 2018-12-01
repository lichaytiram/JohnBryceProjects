package LabGuidePage5;

import java.util.Scanner;

public class ex5try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=(int)(Math.random()*101),y=(int)(Math.random()*101);
		if(x>y)
			System.out.println(x);
		else
			System.out.println(y);
		scan.close();
	}
}
