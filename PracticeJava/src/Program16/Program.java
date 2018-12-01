package Program16;

import java.util.Scanner;

public class Program {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		User user1 = new User("lichay", "tiram");
		User user2 = new User("dorty", "shmueli");
		System.out.println("game 1");
		game(user1, user2);
		System.out.println("game 2");
		game(user1, user2);
		System.out.println("game 3");
		game(user1, user2);
	}

	private static void game(User u1, User u2) {
		GameOneToNine game = new GameOneToNine();
		while (!game.getIswin()) {
			System.out.println(u1.getName());
			game.yourTurn(scan.nextInt());
			if (game.getIswin()) {
				u1.setWin();
				System.out.println(game);
				System.out.println(u1);
				break;
			}
			System.out.println(game);
			System.out.println(u2.getName());
			game.yourTurn(scan.nextInt());
			if (game.getIswin()) {
				u2.setWin();
				System.out.println(game);
				System.out.println(u2);
				break;
			}
			System.out.println(game);
		}
	}
}
