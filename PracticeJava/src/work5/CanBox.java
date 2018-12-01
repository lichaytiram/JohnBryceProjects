package work5;

public class CanBox extends Box {

	private int height, diameter;

	public CanBox(String label, int height, int diameter) {
		super(label);
		this.diameter = diameter;
		this.height = height;
		this.volume = Math.PI * (diameter / 2) * (diameter / 2);
	}

	public CanBox() {
		super("no label");

	}

	public CanBox(String label) {
		super(label);
	}

	public int getHeight() {
		return height;
	}

	public int getDiameter() {
		return diameter;
	}

	public String getData() {
		return super.getData() + "\nCanBox [height- " + getHeight() + ", diameter- " + getDiameter() + "]";
	}

}
