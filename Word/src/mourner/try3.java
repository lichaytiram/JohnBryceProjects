package mourner;

import java.util.Scanner;

public class try3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		if(n/10==6)
			System.out.println("yes");
		else if(n%10==6)
			System.out.println("yes");
		
		scan.close();
	}
}
