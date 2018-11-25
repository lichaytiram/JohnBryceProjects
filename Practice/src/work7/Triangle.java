package work7;

public class Triangle extends Shape {
	private int vertices1, vertices2;

	public Triangle(int x, int y, boolean isVisible, String color, int vertices1, int vertices2) {
		super(x, y, isVisible, color);
		this.vertices1 = vertices1;
		this.vertices2 = vertices2;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTriangle [vertices1=" + vertices1 + ", vertices2=" + vertices2 + "]";
	}

}
