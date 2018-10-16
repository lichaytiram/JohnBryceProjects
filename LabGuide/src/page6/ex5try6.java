package page6;

import java.util.Scanner;

public class ex5try6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int salary = scan.nextInt(), temp = salary, tax = 0;
		if (temp <= 23000) {
			tax += temp * 0.1;
		} else if (temp <= 50000) {
			tax += 23000 * 0.1;
			temp -= 23000;
			tax += temp * 0.2;
		} else if (temp <= 100000) {
			tax += 23000 * 0.1;
			tax += 27000 * 0.2;
			temp -= 50000;
			tax += temp * 0.3;

		} else {
			tax += 23000 * 0.1;
			tax += 27000 * 0.2;
			tax += 50000 * 0.3;
			temp -= 100000;
			tax += temp * 0.4;
		}

		System.out.println("The salary is " + (salary - tax));
		scan.close();
	}
}
