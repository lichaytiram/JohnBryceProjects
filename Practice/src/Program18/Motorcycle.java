package Program18;

public class Motorcycle extends Vehicle {
	private int maxSpeed;

	public Motorcycle(int sizeEngine, int numberOfLicense, int maxSpeed) {
		super(2, sizeEngine, numberOfLicense);
		this.maxSpeed = maxSpeed;
	}

	public Motorcycle(Motorcycle m) {
		super(2, m.getSizeEngine(), m.getNumberOfLicense());
		this.maxSpeed = m.maxSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return super.toString() + "\nMotorcycle [maxSpeed=" + maxSpeed + "]";
	}

}
