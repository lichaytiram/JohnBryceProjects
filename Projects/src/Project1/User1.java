package Project1;

public class User1 extends User {
	public static int wins = 0;
	private String name;

	public User1(char c, String name) {
		super(c);
		this.name = name;
	}

	public char getC() {
		return c;
	}

	@Override
	public String toString() {
		return "User1 [name=" + name + "]";
	}

}
