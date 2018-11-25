package conditions;

import java.util.Scanner;

public class try6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(),y=scan.nextInt();
		if(x%y==0)
			System.out.println("yes");
		else 
			System.out.println("no");
		
		scan.close();
	}
}
