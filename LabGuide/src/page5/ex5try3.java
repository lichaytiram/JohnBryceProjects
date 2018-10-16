package page5;

import java.util.Scanner;

public class ex5try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x=(int)(Math.random()*101);
		if(x<=50)
			System.out.println("Small");
		else
			System.out.println("Big");
		if(x%2==0)
			System.out.println("even");
		else
			System.out.println("odd");
		scan.close();
	}
}
