package Project1;

import java.util.Scanner;

public class Game {
	public static int x = 0;
	char[][] c = new char[3][3];
	private boolean isWin;

	public Game() {
		super();
		int y = 1;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				this.c[i][j] = (char) (y + 48);
				y++;
			}
		}
		this.isWin = false;
		Game.x++;
	}

	public boolean getiswin() {
		return isWin;
	}

	public void getIndex(char x, int row, int col) {
		Scanner scan = new Scanner(System.in);
		while (row > 2) {
			System.out.println("row out of range");
			row = scan.nextInt();
		}
		while (col > 2) {
			System.out.println("col out of range");
			col = scan.nextInt();
		}
		if (this.c[row][col] <= '9' && this.c[row][col] >= '1')
			this.c[row][col] = x;
		else {
			System.out.println("The place is alredy takken!\nChoose a new row and col");
			getIndex(x, scan.nextInt(), scan.nextInt());
		}

		print();
		if (isWin)
			scan.close();
		win(x);

	}

	public void win(char x) {
		for (int i = 0; i < c.length; i++) {
			if ((c[i][0] == x && c[i][1] == x && c[i][2] == x) || (c[0][i] == x && c[1][i] == x && c[2][i] == x)
					|| (c[0][0] == x && c[1][1] == x && c[2][2] == x) || (c[0][2] == x && c[1][1] == x && c[2][0] == x))
				isWin = true;
		}
	}

	private void print() {
		System.out.println();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				if (j == 0)
					System.out.print("|");
				System.out.print(c[i][j] + "|");
			}
			System.out.println("\n-------");
		}
	}

}
