package test;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt(),max1=0,max2=0;
		while(n>0) {
			if(n>max1) {
				max2=max1;
				max1=n;
			}else if(n>max2)
				max2=n;
			n=scan.nextInt();
		}
		System.out.println(max2);
		
		scan.close();
	}
}
