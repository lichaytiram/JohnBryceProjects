package page5;

import java.util.Scanner;

public class ex4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=(int)(Math.random()*101),y=(int)(Math.random()*101);
		System.out.println(x +" and "+y );
		System.out.println("The sum is "+(x+y));
		System.out.println("The average is "+ (x+y)/2);
		System.out.println(x/10 +" "+y/10);
		System.out.println("The rectangle is "+ (x*2+y*2));
		scan.close();
	}
}
