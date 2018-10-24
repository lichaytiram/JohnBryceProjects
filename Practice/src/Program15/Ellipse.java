package Program15;

public class Ellipse extends Circle {
	private int radiusSecond;

	public Ellipse(int thick, String color, int radius, int radiusSecond) {
		super(thick, color, radius);
		this.radiusSecond = radiusSecond > 0 ? radiusSecond : 1;
	}

	@Override
	public String toString() {
		return super.toString() + "Ellipse [radiusSecond=" + radiusSecond + "]\n";
	}

}
