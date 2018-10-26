package Program15;

public class Triangle extends Shape implements IVertices, IShapeWithVertices {
	private int width;
	private int hight;

	public Triangle(int thick, String color, int width, int hight) {
		super(thick, color);
		this.width = width > 0 ? width : 1;
		this.hight = hight > 0 ? hight : 1;
	}

	public int vertices() {
		System.out.println("vertices is 3");
		return 3;
	}

	public Shape shapeWithVertices(Shape s1, Shape s2) {
		if (s1 instanceof Rectangle) {
			return ((Rectangle) s1);
		} else if (s1 instanceof Rectangle) {
			return (Rectangle) s2;
		} else if (s1 instanceof Triangle)
			return (Triangle) s1;
		else if (s2 instanceof Triangle)
			return (Triangle) s2;
		return (Moon) s1;

	}

	@Override
	public String toString() {
		return super.toString() + "Triangle [width=" + width + ", hight=" + hight + "]\n";
	}

}
