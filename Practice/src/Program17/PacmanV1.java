package Program17;

public class PacmanV1 {
	private char[][] game = new char[4][4]; // size of arena
	private boolean gameIsOver; // if the game is finish
	private boolean isWin; // if win or loss

	public PacmanV1() {
		super();
		startArena();
		this.gameIsOver = false;
		this.isWin = false;
		// default
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
		if (step == 'd' && Col < 3)
			Col++;
		if (step == 'a' && Col > 0)
			Col--;
		if (step == 'w' && Row > 0)
			Row--;
		if (step == 's' && Row < 3)
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
				System.out.println("Nice try ,You lose Level one of game\nmaybe next time <(^_^)>");

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
