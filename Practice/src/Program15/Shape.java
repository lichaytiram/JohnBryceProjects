package Program15;

public abstract class Shape {
	private int thick;
	private String color;

	public Shape(int thick, String color) {
		super();
		this.thick = thick > 0 ? thick : 1;
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return "Shape [thick=" + thick + ", color=" + color + "]\n";
	}

}
