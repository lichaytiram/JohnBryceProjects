package Program15;

public class Moon extends Shape implements IVertices, IRoll,IShapeWithVertices {
	private int circle1;
	private int circle2;

	public Moon(int thick, String color, int circle1, int circle2) {
		super(thick, color);
		this.circle1 = circle1;
		this.circle2 = circle2;
	}

	public int vertices() {
		System.out.println("vertices is ");
		return 2;
	}

	public String roll() {
		return "Moon is shape roll";
	}

	@Override
	public String toString() {
		return super.toString() + "Moon [circle1=" + circle1 + ", circle2=" + circle2 + "]\n";
	}

}
