package work5;

public class Box {
	protected String label;
	protected double volume;

	public Box(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public double getVolume() {
		return volume;
	}

	public String getData() {
		return "\nBox [label- " + getLabel() + " ,volume- " + getVolume() + "]";
	}
}
