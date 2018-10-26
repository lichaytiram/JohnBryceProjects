package Program15;

public class Rectangle extends Shape implements IVertices ,IShapeWithVertices{
	private int length;
	private int width;

	public Rectangle(int thick, String color, int length, int width) {
		super(thick, color);
		this.length = length > 0 ? length : 1;
		this.width = width > 0 ? width : 1;
	}

	public int vertices() {
		System.out.println("vertices is 4");
		return 4;
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
		return super.toString() + "Rectangle [length=" + length + ", width=" + width + "]\n";
	}

}
