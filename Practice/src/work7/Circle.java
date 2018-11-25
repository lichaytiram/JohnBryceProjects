package work7;

public class Circle extends Shape {
	private int radius;

	public Circle(int x, int y, boolean isVisible, String color, int radius) {
		super(x, y, isVisible, color);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCircle [radius=" + radius + "]";
	}

}
