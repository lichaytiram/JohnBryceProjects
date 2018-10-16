package page32;

import java.util.Scanner;

public class try8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt(),sum=0;
		for(int i=1;i<=n;i++) {
			if(i%4==0||i%7==0)
				sum+=i;
		}
		System.out.println(sum);
		scan.close();
	}
}
