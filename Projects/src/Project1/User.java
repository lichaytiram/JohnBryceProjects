package Project1;

public class User {
	private char c;
	private int win;

	public User(char c) {
		super();
		this.c = c;
	}

	public char getC() {
		return c;
	}

	public void setWin() {
		this.win++;
	}

	public int getWin() {
		return win;
	}

	@Override
	public String toString() {
		return "User [c=" + c + ", win=" + getWin() + " times!]";
	}

}
