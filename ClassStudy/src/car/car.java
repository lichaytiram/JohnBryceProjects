package car;

public class car {
	String color, brand;
	int price, maxSpeed, currentSpeed;

	public void color(String color) {
		this.color = color;
	}

	public void accelerate(int currentSpeed, int maxSpeed) {
		if (currentSpeed <= maxSpeed)
			currentSpeed++;
		System.out.println(currentSpeed);
	}

	public void brake(int currentSpeed) {
		if (currentSpeed > 0)
			currentSpeed--;
		System.out.println(currentSpeed);
	}

	public void honk() {
		System.out.println("Bip!");
	}

	public String toString() {
		return "color " + color + " brand " + brand + " price " + price + " maxSpeed " + maxSpeed + " currentSpeed "
				+ currentSpeed;
	}

}
