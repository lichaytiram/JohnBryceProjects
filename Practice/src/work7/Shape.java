package work7;

public class Shape {
	protected int x, y;
	protected boolean isVisible;
	protected String color;

	public Shape(int x, int y, boolean isVisible, String color) {
		this.x = x;
		this.y = y;
		this.isVisible = isVisible;
		this.color = color;
	}

	public void setVisible(boolean value) {
		this.isVisible = value;
	}

	public String getColor() {
		return color;
	}

	public void move(int deltaX, int deltaY) {
		this.x = deltaX;
		this.y = deltaY;
	}

	@Override
	public String toString() {
		return "\nShape [x=" + x + ", y=" + y + ", isVisible=" + isVisible + ", color=" + color + "]";
	}

}
