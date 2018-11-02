package Program18;

public class Car extends Vehicle {
	private String color;

	public Car(int sizeEngine, int numberOfLicense, String color) {
		super(4, sizeEngine, numberOfLicense);
		this.color = color;
	}

	public Car(Car c) {
		super(4, c.getSizeEngine(), c.getNumberOfLicense());
		this.color = c.color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void lastOilTest(String oilTest) {
		System.out.println("Your change your wipers");
	}

	@Override
	public String toString() {
		return super.toString() + "\nCar [color=" + color + "]";
	}

}
