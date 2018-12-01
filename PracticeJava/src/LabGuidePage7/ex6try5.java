package LabGuidePage7;

import java.util.Scanner;

public class ex6try5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = (int) (Math.random() * 10001), temp = x, count = 0;
		System.out.println("your number random is " + x);
		while (temp > 0) {
			temp /= 10;
			count++;
		}
		System.out.println("number of digit is " + count);
		temp = x;
		while (temp > 0) {
			if (temp < 10)
				System.out.println("your left number is " + temp);

			temp /= 10;
		}
		temp = x;
		int sum = 0;
		while (temp > 0) {
			sum += temp % 10;
			temp /= 10;
		}
		System.out.println("The of the number's digit is " + sum);
		scan.close();
	}
}
