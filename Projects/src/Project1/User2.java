package Project1;

public class User2 extends User {
	public static int wins = 0;
	private String name;

	public User2(char c, String name) {
		super(c);
		this.name = name;
	}

	public char getC() {
		return c;
	}

	@Override
	public String toString() {
		return "User2 [name=" + name + "]";
	}

}
