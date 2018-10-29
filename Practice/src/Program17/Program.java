package Program17;

import java.util.Scanner;

public class Program {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		User u1 = new User("lichay", "tiram");
		Pacman p1 = new Pacman();
		game1(u1, p1);

	}

	public static void game1(User user, Pacman pacman) {
		System.out.println(user);
		System.out.println("The game is start Good luck!\nWhere you want to go W/s/a/d");
		while (!pacman.getGameIsOver()) {
			pacman.printArena();
			pacman.step(scan.next().charAt(0));
		}
	}
}
