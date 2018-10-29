package Program17;

public class PacmanV3 {
	private char[][] game = new char[8][8]; // size of arena
	private boolean gameIsOver; // if the game is finish
	private boolean isWin; // if win or loss
	private int pickAllMoney = 6;

	public PacmanV3() {
		super();
		System.out.println(
				"The game is started Good luck!\nLevel three\nWhere you want to go press w/s/a/d and after press enter\nRules: \n1) You are is C.\n2) Don't touch the X this is a bombs(can kill you).\n3) Go to W to win this level.\n4) Must take all money ($) from this map for win this level.\n5) Monster has been show recently! go aways from them! (Tip-The monster move first).\n6) Now you got a weapon! you can destroy one wall for each weapon by press f,\nThe weapon show on map this symbol (H).");
		startArena();
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
		if (step == 'd' && Col < 7)
			Col++;
		if (step == 'a' && Col > 0)
			Col--;
		if (step == 'w' && Row > 0)
			Row--;
		if (step == 's' && Row < 7)
			Row++;

		if (game[Row][Col] == '$')
			pickAllMoney--;
		game[row][col] = '*';
		game[Row][Col] = 'C';

		if (Row == 1 && Col == 0)
			gameIsOver = true;
		if (Row == 1 && Col == 2)
			gameIsOver = true;
		if (Row == 1 && Col == 3)
			gameIsOver = true;
		if (Row == 1 && Col == 7)
			gameIsOver = true;
		if (Row == 2 && Col == 3)
			gameIsOver = true;
		if (Row == 2 && Col == 7)
			gameIsOver = true;
		if (Row == 3 && Col == 1)
			gameIsOver = true;
		if (Row == 3 && Col == 3)
			gameIsOver = true;
		if (Row == 3 && Col == 5)
			gameIsOver = true;
		if (Row == 3 && Col == 6)
			gameIsOver = true;
		if (Row == 3 && Col == 7)
			gameIsOver = true;
		if (Row == 4 && Col == 3)
			gameIsOver = true;
		if (Row == 4 && Col == 5)
			gameIsOver = true;
		if (Row == 4 && Col == 6)
			gameIsOver = true;
		if (Row == 4 && Col == 7)
			gameIsOver = true;
		if (Row == 5 && Col == 1)
			gameIsOver = true;
		if (Row == 5 && Col == 4)
			gameIsOver = true;
		if (Row == 5 && Col == 5)
			gameIsOver = true;
		if (Row == 6 && Col == 2)
			gameIsOver = true;
		if (Row == 6 && Col == 4)
			gameIsOver = true;
		if (Row == 7 && Col == 3)
			gameIsOver = true;
		if (Row == 7 && Col == 4)
			gameIsOver = true;
		if (Row == 7 && Col == 6)
			gameIsOver = true;

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
				System.out.println("Good job you Won the Level three of game -> next level\n");
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
