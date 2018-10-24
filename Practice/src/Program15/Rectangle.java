package Program15;

public class Rectangle extends Shape implements IVertices {
	private int length;
	private int width;

	public Rectangle(int thick, String color, int length, int width) {
		super(thick, color);
		this.length = length > 0 ? length : 1;
		this.width = width > 0 ? width : 1;
	}

	public int vertices() {
		System.out.println("vertices is ");
		return 4;
	}

	@Override
	public String toString() {
		return super.toString() + "Rectangle [length=" + length + ", width=" + width + "]\n";
	}

}
