package page6;

import java.util.Scanner;

public class ex5try5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = (int) (Math.random() * 101), y = (int) (Math.random() * 101), z = (int) (Math.random() * 101);
		if (x > y && x > z)
			System.out.println(x);
		else if (z > y && z > x)
			System.out.println(z);
		else
			System.out.println(y);

		scan.close();
	}
}
