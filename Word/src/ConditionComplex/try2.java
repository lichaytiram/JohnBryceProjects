package ConditionComplex;

import java.util.Scanner;

public class try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt(), n2 = scan.nextInt(), n3 = scan.nextInt(), max = 0, mid = 0, low = 0;
		if (n1 > n2) {
			if (n1 > n3) {
				max = n1;
				if (n2 > n3) {
					mid = n2;
					low = n3;
				} else {
					mid = n3;
					low = n2;
				}
			} else {
				max = n3;
				mid = n1;
				low = n2;
			}

		} else {
			if (n2 > n3) {
				max = n2;
				if (n1 > n3) {
					mid = n1;
					low = n3;
				} else {
					mid = n3;
					low = n1;
				}
			} else {
				max = n3;
				mid = n2;
				low = n1;
			}
		}

		if (low + 2 == max && mid + 1 == max)
			System.out.println("okvim");
		System.out.println(low + " " + mid + " " + max);
		scan.close();
	}
}
