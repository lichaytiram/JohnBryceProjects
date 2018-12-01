package Program8;

public class Car {
	private int balance;

	public Car() {
		balance = 0;
	}

	public void slow() {
		if (balance > 0)
			balance--;
		else
			System.out.println("The car don't move");
	}

	public void gaz() {
		if (balance < 220)
			balance++;
		else
			System.out.println("max speed");
	}

	public void stop() {
		balance = 0;
	}

	@Override
	public String toString() {
		return "Car [balance=" + balance+"]";
	}

}
