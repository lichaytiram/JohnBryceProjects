package Program16;

public class User {
	private String firstName;
	private String lastName;
	private int win;

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.win = 0;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public void setWin() {
		win++;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", win=" + win + "]";
	}

}
