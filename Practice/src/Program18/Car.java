package Program18;

public class Car extends vehicle {
	private String color;

	public Car(int sizeEngine, int numberOfLicense, String color) {
		super(4, sizeEngine, numberOfLicense);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCar [color=" + color + "]";
	}

}
