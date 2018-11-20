package LabGuidePage5;

import java.util.Scanner;

public class ex5try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int salary=(int)(Math.random()*6001);
		while(salary<5000 || salary>6000)
			salary=(int)(Math.random()*6001);
		System.out.println("The salary is "+salary);
		if(salary*1.1<6000)
			salary*=1.1;
		
			
		System.out.println("The update salary is "+salary);
		scan.close();
	}
}
