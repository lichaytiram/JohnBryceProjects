package work3;

public class Box {
	private double width, height, length;

	public void printmax(int max) {
		if (this.area() > max) {
			System.out.println(this.area());
		}
	}

	public Box(double width, double heigth, double length) {
		this.width = width;
		this.height = heigth;
		this.length = length;
	}

	public Box(double sides) {
		this.width = Math.sqrt(sides);
		this.height = Math.sqrt(sides);
		this.length = Math.sqrt(sides);
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeigth() {
		return this.height;
	}

	public double getLength() {
		return this.length;
	}

	public double area() {
		return width * height * length;
	}

	public double volume() {
		return 2 * width * height + 2 * width * length + 2 * height * length;
	}

}
