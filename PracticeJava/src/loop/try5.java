package loop;

import java.util.Scanner;

public class try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), sum = 0,temp=1;
		if(n1<0) {
			n1*=-1;
			temp*=-1;
		}
		if(n2<0) {
			n2*=-1;
			temp*=-1;
		}
		for (int i = 0; i < n1; i++) {
			sum += n2;
		}
		
		System.out.println(temp*sum);

		scan.close();
	}
}
