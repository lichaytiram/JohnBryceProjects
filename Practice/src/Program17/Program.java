package Program17;

import java.util.Scanner;

public class Program {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		User u1 = new User("lichay", "tiram");
		PacmanV1 p1 = new PacmanV1();
		game1(u1, p1);

	}

	public static void game1(User user, PacmanV1 pacman) {

		System.out.println(user);
		System.out.println("The game is started Good luck!\nLevel one\nWhere you want to go click W/s/a/d");
		while (!pacman.getGameIsOver()) {
			pacman.printArena();
			pacman.step(scan.next().charAt(0));
		}
		if (pacman.getisWin()) {
			PacmanV2 p1 = new PacmanV2();
			game2(user, p1);
		}
	}

	public static void game2(User user, PacmanV2 pacman) {
		System.out.println(user);
		System.out.println("The game is started Good luck!\nLevel two\nWhere you want to go click W/s/a/d");
		while (!pacman.getGameIsOver()) {
			pacman.printArena();
			pacman.step(scan.next().charAt(0));
		}
	}
}
