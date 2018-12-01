package PacmanGame;

public class PacmanV1 {
	private char[][] game = new char[4][4]; // size of arena
	private boolean gameIsOver; // if the game is finish
	private boolean isWin; // if win or loss

	public PacmanV1() {
		super();
		System.out.println(
				"The game is started Good luck!\nLevel one\nWhere you want to go press w/s/a/d and after press enter\nRules: \n1) You are is C.\n2) Don't touch the X this is a bombs(can kill you).\n3) Go to W to win this level.");
		startArena();
		this.gameIsOver = false;
		this.isWin = false;
		// default this level
		game[3][0] = 'C';
		game[1][1] = 'X';
		game[2][2] = 'X';
		game[1][2] = 'W';
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

		game[row][col] = '*';
		game[Row][Col] = 'C';
		if (Row == 1 && Col == 1)
			gameIsOver = true;
		if (Row == 2 && Col == 2)
			gameIsOver = true;
		if (Row == 1 && Col == 2) {
			isWin = true;
			gameIsOver = true;
		}

	}

	public boolean getisWin() {
		return isWin;
	}

	// if the game is finish

	public boolean getGameIsOver() {
		if (gameIsOver) {
			if (isWin)
				System.out.println("Good job you Won the Level one of game -> next level\n");
			else
				System.out.println("Nice try ,You lose Level one of game\nMaybe next time <(^_^)>");

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
