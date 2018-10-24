package Program15;

public class Circle extends Shape implements IRoll, IShapeWithVertices {
	private int radius;

	public Circle(int thick, String color, int radius) {
		super(thick, color);
		this.radius = radius > 0 ? radius : 1;
	}

	public String roll() {
		return "Circle is shape roll";
	}

	@Override
	public String toString() {
		return super.toString() + "Circle [radius=" + radius + "]\n";
	}

}
