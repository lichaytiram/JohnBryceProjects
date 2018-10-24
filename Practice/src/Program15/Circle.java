package Program15;

public class Circle extends Shape {
	private int radius;

	public Circle(int thick, String color, int radius) {
		super(thick, color);
		this.radius = radius > 0 ? radius : 1;
	}

	@Override
	public String toString() {
		return super.toString() + "Circle [radius=" + radius + "]\n";
	}

}
