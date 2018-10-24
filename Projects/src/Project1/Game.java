package Project1;

import java.util.Scanner;

public class Game {
	public static int x = 0;
	char[][] c = new char[3][3];

	public Game(char[][] c) {
		super();
		int y = 1;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				this.c[i][j] = (char) (y + 48);
				y++;
			}
		}
		Game.x++;
	}

	public void getIndex(User u,char x, int row, int col) {
		Scanner scan = new Scanner(System.in);
		if (this.c[row][col] < '9' && this.c[row][col] > '1')
			this.c[row][col] = x;
		else {
			System.out.println("The place is alredy takken!\nChoose a new row and col");
			getIndex(u,x, scan.nextInt(), scan.nextInt());
		}
		scan.close();
		if(win(x)) {
			if(u) {
			
			}
			
		}else 
			// loss
	}

	public boolean win(char x) {
		if ((c[0][0] == x && c[0][1] == x && c[0][2] == x) || (c[1][0] == x && c[1][1] == x && c[1][2] == x)||())
			return true;
		return false;
	}

}
