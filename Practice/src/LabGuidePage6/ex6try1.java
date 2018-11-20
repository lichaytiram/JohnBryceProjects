package LabGuidePage6;

import java.util.Scanner;

public class ex6try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = (int) (Math.random() * 101);
		for (int i = 1; i <= x; i++) {
			System.out.println(i);
			
		}
		
		
		scan.close();
	}
}
