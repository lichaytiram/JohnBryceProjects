package Project1;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		User u1 = new User('x');
		User u2 = new User('o');
		Game g1 = new Game();
		while (!g1.getiswin()) {
			System.out.println("choose row and column for user 1");
			g1.getIndex(u1.getC(), scan.nextInt(), scan.nextInt());
			if (g1.getiswin())
				break;

			System.out.println("choose row and column for user 2");
			g1.getIndex(u2.getC(), scan.nextInt(), scan.nextInt());
		}
		scan.close();
	}
}
