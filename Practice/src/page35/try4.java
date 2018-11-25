package page35;

import java.util.Scanner;

public class try4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int positive = 0, negative = 0, impossible = 0;
		boolean check = true;
		for (int i = 0; i < 170; i++) {
			int state = scan.nextInt();
			switch (state) {
			case 1:
				positive++;
				break;
			case 2:
				negative++;
				break;
			case 3:
				impossible++;
				break;
			}
			if (state == 4) {
				System.out.println(i);
				check = false;
				break;
			}

		}
		if (check)
			System.out.println("positive " + positive + " negative " + negative + " impossible " + impossible);

		scan.close();
	}
}
