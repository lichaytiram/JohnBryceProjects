package charts;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hours");
		double x=scan.nextDouble();
		System.out.println("get per hour");
		double Phour=scan.nextDouble();
		System.out.println("you worked hours "+x+" get per Hour "+Phour);
		System.out.println(x*Phour);
		
		
		
		
		scan.close();
	}
}
