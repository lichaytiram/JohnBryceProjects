package car;

import java.util.Scanner;

public class c {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		car c = new car(50000,220,"blue","nissan");
		System.out.println(c);
	//	c.setprice=scan.nextInt();
	//	System.out.println(c);
		scan.close();
	}

}
