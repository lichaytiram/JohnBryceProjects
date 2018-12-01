package page32;

import java.util.Scanner;

public class try7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.print(i);
		}
		System.out.println();
		for(int i=1;i<=n;i++) {
			if(i%2==0)
				System.out.print(i);
		}
		
		scan.close();
	}
}
