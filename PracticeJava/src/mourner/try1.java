package mourner;

import java.util.Scanner;

public class try1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		if(n==0)
			System.out.println("This 0");
		else if(n>0)
			System.out.println("positive");
		else
			System.out.println("negative");
		
		
		
		scan.close();
	}
}
