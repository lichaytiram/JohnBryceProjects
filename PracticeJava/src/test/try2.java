package test;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for (long i = 10; i <= 1000; i+=10) {
			long sum = 1;
			for (long j = 1; j <= i; j++) {
				sum *= j;
			}
			System.out.println(sum);
		}

		scan.close();
	}
}
