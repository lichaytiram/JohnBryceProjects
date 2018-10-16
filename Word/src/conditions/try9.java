package conditions;

import java.util.Scanner;

public class try9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(),sum=75,s=0;
		if(n<=100)
			n*=40;
		else {
			s=100*40;
			n-=100;
			n*=30;
			n+=s;
		}
		sum+=n;
		sum*=117/100;
		System.out.println(sum);
		
		scan.close();
	}
}
