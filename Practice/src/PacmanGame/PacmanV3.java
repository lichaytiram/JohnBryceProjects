package PacmanGame;

import java.util.Scanner;

public class PacmanV3 {
	private char[][] game = new char[8][8]; // size of arena
	private boolean gameIsOver; // if the game is finish
	private boolean isWin; // if win or loss
	private int pickAllMoney;
	private int weapon;

	private static Scanner scan = new Scanner(System.in);

	public PacmanV3() {
		super();
		System.out.println(
				"The game is started Good luck!\nLevel three\nWhere you want to go press w/s/a/d and after press enter\nRules: \n1) You are is C.\n2) Don't touch the X this is a bombs(can kill you).\n3) Go to W to win this level.\n4) Must take all money ($) from this map for win this level.\n5) Monster has been show recently! go away from them! (Tip-The monster move first).\n6) Now you got a weapon! you can destroy one wall for each weapon by press f,\nThe weapon show on map this symbol (H).");
		startArena();
		pickAllMoney = 6;
		this.gameIsOver = false;
		this.isWin = false;
		// default this level
		game[7][0] = 'C';
		game[1][0] = 'X';
		game[1][2] = 'X';
		game[1][3] = 'X';
		game[1][7] = 'X';
		game[2][3] = 'X';
		game[2][7] = 'X';
		game[3][1] = 'X';
		game[3][3] = 'X';
		game[3][5] = 'X';
		game[3][6] = 'X';
		game[3][7] = 'X';
		game[4][3] = 'X';
		game[4][5] = 'X';
		game[4][6] = 'X';
		game[4][7] = 'X';
		game[5][1] = 'X';
		game[5][4] = 'X';
		game[5][5] = 'X';
		game[6][2] = 'X';
		game[6][4] = 'X';
		game[7][3] = 'X';
		game[7][4] = 'X';
		game[7][6] = 'X';

		game[0][0] = '$';
		game[0][7] = '$';
		game[0][7] = '$';
		game[3][0] = '$';
		game[4][4] = '$';
		game[7][2] = '$';
		game[7][5] = '$';

		game[6][3] = 'H';

		game[2][4] = 'M';

		game[7][7] = 'W';
	}

	// start game

	private void startArena() {

		for (int row = 0; row < game.length; row++) {
			for (int col = 0; col < game[row].length; col++) {
				game[row][col] = '*';
			}
		}
	}

	// players step
	public void step(char step) {
		int row = 0, col = 0; // C
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] == 'C') {
					row = i;
					col = j;
				}
			}
		}

		int Row = row, Col = col; // move

		if (step == 'd' && Col < game.length - 1)
			Col++;
		if (step == 'a' && Col > 0)
			Col--;
		if (step == 'w' && Row > 0)
			Row--;
		if (step == 's' && Row < game.length - 1)
			Row++;

		// weapon
		if (game[6][3] == 'H' && Row == 6 && Col == 3)
			weapon++;
		if (weapon > 0 && step == 'r') {
			System.out.println("Where do you want to shoot?\nChoose angle by press -> w/s/a/d");
			char angle = scan.next().charAt(0);
			while (angle != 'w' && angle != 's' && angle != 'a' && angle != 'd')
				angle = scan.next().charAt(0);
			boolean useWeapon = false;
			if (angle == 'd' && col + 1 <= game[0].length - 1) {
				game[row][col + 1] = '*';
				useWeapon = true;
			} else if (angle == 'a' && col - 1 >= 0) {
				game[row][col - 1] = '*';
				useWeapon = true;
			} else if (angle == 'w' && row - 1 >= 0) {
				game[row - 1][col] = '*';
				useWeapon = true;
			} else if (angle == 's' && row + 1 <= game[0].length - 1) {
				game[row + 1][col] = '*';
				useWeapon = true;
			}

			if (useWeapon) {
				weapon--;
				System.out.println("Boom!\nThe bombs is destroy by your weapon");
			} else
				System.out.println("This place out of arena!");
		} else if (step == 'r')
			System.out.println("dont have weapon yet!");

		// monster

		if (game[2][4] == 'M') {
			game[2][4] = '*';
			game[1][4] = 'M';
			if (row == 1 && col == 4)
				gameIsOver = true;

		} else if (game[1][4] == 'M') {
			game[1][4] = '*';
			game[1][5] = 'M';
			if (row == 1 && col == 5)
				gameIsOver = true;
		} else if (game[1][5] == 'M') {
			game[1][5] = '*';
			game[2][5] = 'M';
			if (row == 2 && col == 5)
				gameIsOver = true;
		} else if (game[2][5] == 'M') {
			game[2][5] = '*';
			game[2][4] = 'M';
			if (row == 2 && col == 4)
				gameIsOver = true;
		}
		if (game[Row][Col] == '$')
			pickAllMoney--;

		if (Row == 1 && Col == 0 && game[1][0] == 'X')
			gameIsOver = true;
		if (Row == 1 && Col == 2 && game[1][2] == 'X')
			gameIsOver = true;
		if (Row == 1 && Col == 3 && game[1][3] == 'X')
			gameIsOver = true;
		if (Row == 1 && Col == 7 && game[1][7] == 'X')
			gameIsOver = true;
		if (Row == 2 && Col == 3 && game[2][3] == 'X')
			gameIsOver = true;
		if (Row == 2 && Col == 7 && game[2][7] == 'X')
			gameIsOver = true;
		if (Row == 3 && Col == 1 && game[3][1] == 'X')
			gameIsOver = true;
		if (Row == 3 && Col == 3 && game[3][3] == 'X')
			gameIsOver = true;
		if (Row == 3 && Col == 5 && game[3][5] == 'X')
			gameIsOver = true;
		if (Row == 3 && Col == 6 && game[3][6] == 'X')
			gameIsOver = true;
		if (Row == 3 && Col == 7 && game[3][7] == 'X')
			gameIsOver = true;
		if (Row == 4 && Col == 3 && game[4][3] == 'X')
			gameIsOver = true;
		if (Row == 4 && Col == 5 && game[4][5] == 'X')
			gameIsOver = true;
		if (Row == 4 && Col == 6 && game[4][6] == 'X')
			gameIsOver = true;
		if (Row == 4 && Col == 7 && game[4][7] == 'X')
			gameIsOver = true;
		if (Row == 5 && Col == 1 && game[5][1] == 'X')
			gameIsOver = true;
		if (Row == 5 && Col == 4 && game[5][4] == 'X')
			gameIsOver = true;
		if (Row == 5 && Col == 5 && game[5][5] == 'X')
			gameIsOver = true;
		if (Row == 6 && Col == 2 && game[6][2] == 'X')
			gameIsOver = true;
		if (Row == 6 && Col == 4 && game[6][4] == 'X')
			gameIsOver = true;
		if (Row == 7 && Col == 3 && game[7][3] == 'X')
			gameIsOver = true;
		if (Row == 7 && Col == 4 && game[7][4] == 'X')
			gameIsOver = true;
		if (Row == 7 && Col == 6 && game[7][6] == 'X')
			gameIsOver = true;
		game[row][col] = '*';
		game[Row][Col] = 'C';

		if (Row == 7 && Col == 7 && pickAllMoney == 0) {
			isWin = true;
			gameIsOver = true;
		}
		if (!isWin && Row == 7 && Col == 7) {
			game[7][7] = 'W';
			game[row][col] = 'C';
		}

	}

	public boolean getisWin() {
		return isWin;
	}

	// if the game is finish

	public boolean getGameIsOver() {
		if (gameIsOver) {
			if (isWin)
				System.out.println("Good job you Won the game! ,more Levels coming soon\nCredit to Lichay Tiram");
			else
				System.out.println("Nice try ,You lose Level three of game\nMaybe next time <(^_^)>");

			return true;
		} else
			return false;
	}

	public void printArena() {
		for (char[] out : game) {
			for (char inside : out) {
				System.out.print(inside + "   ");
			}
			System.out.println("\n");
		}
		System.out.println();
	}

}
