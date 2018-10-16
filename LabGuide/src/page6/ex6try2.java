package page6;

import java.util.Scanner;

public class ex6try2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = (int) (Math.random() * 101), y = (int) (Math.random() * 101), delta;
		if (x < y)
			delta = 1;
		else
			delta = -1;

		for (int i = x; i != y; i += delta)
			System.out.println(i);
		System.out.println(y +" last");

		scan.close();
	}
}
