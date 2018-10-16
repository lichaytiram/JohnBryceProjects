package work7;

public class Rectangle extends Shape {
	private int heigth, width;

	public Rectangle(int x, int y, boolean isVisible, String color, int heigth, int width) {
		super(x, y, isVisible, color);
		this.heigth = heigth;
		this.width = width;
	}

	@Override
	public String toString() {
		return super.toString() + "\nRectangle [heigth=" + heigth + ", width=" + width + "]";
	}

}
