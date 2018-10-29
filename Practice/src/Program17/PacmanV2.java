package Program17;

public class PacmanV2 {
	private char[][] game = new char[5][5]; // size of arena
	private boolean gameIsOver; // if the game is finish
	private boolean isWin; // if win or loss
	private int pickAllMoney = 3;

	public PacmanV2() {
		super();
		startArena();
		this.gameIsOver = false;
		this.isWin = false;
		// default
		game[4][0] = 'C';
		game[0][1] = 'X';
		game[1][3] = 'X';
		game[2][1] = 'X';
		game[2][4] = 'X';
		game[3][2] = 'X';
		game[4][3] = 'X';
		game[0][0] = '$';
		game[1][4] = '$';
		game[4][2] = '$';
		game[4][4] = 'W';
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
		if (step == 'd' && Col < 4)
			Col++;
		if (step == 'a' && Col > 0)
			Col--;
		if (step == 'w' && Row > 0)
			Row--;
		if (step == 's' && Row < 4)
			Row++;

		if (game[Row][Col] == '$')
			pickAllMoney--;
		game[row][col] = '*';
		game[Row][Col] = 'C';

		if (Row == 0 && Col == 1)
			gameIsOver = true;
		if (Row == 1 && Col == 3)
			gameIsOver = true;
		if (Row == 2 && Col == 1)
			gameIsOver = true;
		if (Row == 2 && Col == 4)
			gameIsOver = true;
		if (Row == 3 && Col == 2)
			gameIsOver = true;
		if (Row == 4 && Col == 3)
			gameIsOver = true;

		if (Row == 4 && Col == 4 && pickAllMoney == 0) {
			isWin = true;
			gameIsOver = true;
		}
		if (!isWin && Row == 4 && Col == 4) {
			game[4][4] = 'W';
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
				System.out.println("Good job you Won the Level two of game -> next level\n");
			else
				System.out.println("Nice try ,You lose Level two of game\nmaybe next time <(^_^)>");

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
