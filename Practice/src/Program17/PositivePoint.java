package Program17;

public class PositivePoint extends Point {

	public PositivePoint(int x, int y) {
		super(x = x > 0 ? x : 0, y = y > 0 ? y : 0);
	}

	@Override
	public String toString() {
		return "PositivePoint [" + super.toString() + "]";
	}

}
