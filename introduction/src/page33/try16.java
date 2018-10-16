package page33;

import java.util.Scanner;

public class try16 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum=0;
		for(int i=0;i<50;i++) {
			int n=scan.nextInt();
			sum+=n;
		}
		for(int i=0;i<1000;i++) {
			int n=scan.nextInt();
			sum+=n;
		}
		
		System.out.println(sum);
		scan.close();
	}
}

