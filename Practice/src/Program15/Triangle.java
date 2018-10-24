package Program15;

public class Triangle extends Shape implements IVertices {
	private int width;
	private int hight;

	public Triangle(int thick, String color, int width, int hight) {
		super(thick, color);
		this.width = width > 0 ? width : 1;
		this.hight = hight > 0 ? hight : 1;
	}

	public int vertices() {
		System.out.println("vertices is ");
		return 3;
	}

	@Override
	public String toString() {
		return super.toString() + "Triangle [width=" + width + ", hight=" + hight + "]\n";
	}

}
