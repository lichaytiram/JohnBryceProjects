package Program15;

public class Moon extends Shape implements IVertices, IRoll, IShapeWithVertices {
	private int circle1;
	private int circle2;

	public Moon(int thick, String color, int circle1, int circle2) {
		super(thick, color);
		this.circle1 = circle1;
		this.circle2 = circle2;
	}

	public int vertices() {
		System.out.println("vertices is 2");
		return 2;
	}

	public String roll() {
		return "Moon is shape roll";
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
		return super.toString() + "Moon [circle1=" + circle1 + ", circle2=" + circle2 + "]\n";
	}

}
