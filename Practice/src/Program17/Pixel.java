package Program17;

public class Pixel extends PositivePoint {
	private String color;

	public Pixel(int x, int y, String color) {
		super(x, y);
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
		return super.toString() + "\nPixel [color=" + color + "]";
	}

}
