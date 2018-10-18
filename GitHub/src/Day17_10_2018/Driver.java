package Day17_10_2018;

public class Driver extends Person {
	private int numberOfPassport;

	public Driver(String firstName, String lastName, int numberOfPassport) {
		super(firstName, lastName);
		this.numberOfPassport = numberOfPassport;
	}

	@Override
	public String toString() {
		return super.toString() + "Driver [numberOfPassport=" + numberOfPassport + "]\n";
	}

}
