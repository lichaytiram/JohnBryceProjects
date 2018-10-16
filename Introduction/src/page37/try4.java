package page37;

import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println();
			for(int j=i;j<=n;j++) {
				System.out.print(j);
			}
		}
		
		
		scan.close();
	}
}
