package Project1;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		User u1 = new User('x');
		User u2 = new User('o');
		Game g1 = new Game();
		Game g2 = new Game();
		gameplay(u1, u2, g1, scan);
		System.out.println("second game");
		gameplay(u1, u2, g2, scan);
		scan.close();
	}

	public static void gameplay(User u1, User u2, Game g1, Scanner scan) {
		while (!g1.getiswin()) {
			System.out.println("choose row and column for user 1");
			g1.getIndex(u1.getC(), scan.nextInt(), scan.nextInt());
			if (g1.getiswin()) {
				u1.setWin();
				System.out.println("The winer is " + u1.getC() + " and won " + u1.getWin() + " times!");
				break;
			}
			System.out.println("choose row and column for user 2");
			g1.getIndex(u2.getC(), scan.nextInt(), scan.nextInt());
			if (g1.getiswin()) {
				u2.setWin();
				System.out.println("The winer is " + u2.getC() + " and won " + u2.getWin() + " times!");
				break;
			}
		}
	}
}
