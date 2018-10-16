package page8;

import java.util.Scanner;

public class ex7try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 20; i++) {
			int sums = 0;
			String name = scan.next();
			for (int j = 0; j < 10; j++) {
				int[] arrs = new int[10];
				arrs[j] = (int) (Math.random() * 101);
				sums += arrs[j];
			}
			sums/=10;
			sum+=sums;
			System.out.println(name + " his/her sum is " + sums);
		}
		sum/=20;
		System.out.println("all average is " + sum);
		scan.close();
	}
}
