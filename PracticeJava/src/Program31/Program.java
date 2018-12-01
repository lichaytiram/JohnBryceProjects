package Program31;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Direction where = Direction.WEST;
		System.out.println("inpute plz");
		try {
			Direction where2 = Direction.valueOf(scan.next());
			System.out.println("This is where2 - " + where2);
		} catch (java.lang.IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(where);
		System.out.println();
		for (Direction p : Direction.values()) {
			System.out.println(p);
		}
		scan.close();
	}
}
