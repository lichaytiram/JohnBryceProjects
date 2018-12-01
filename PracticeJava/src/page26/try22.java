package page26;

import java.util.Scanner;

public class try22 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = 1, n2 = 1,val=scan.nextInt(),max=0;
		while(val>=max)
			if(n1<=n2) {
			n1+=n2;
			max=n1;
			}
			else {
				n2+=n1;
				max=n2;
			}
		System.out.println(max);
		scan.close();

	}

}
