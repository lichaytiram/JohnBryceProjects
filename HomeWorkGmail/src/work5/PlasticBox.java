package work5;

public class PlasticBox extends Box {

	private int length, height, width;

	public PlasticBox(String label, int length, int height, int width) {
		super(label);
		this.length = length;
		this.height = height;
		this.width = width;
		super.volume = width * height * length;
	}

	public PlasticBox() {
		super("no label");
	}

	public PlasticBox(String label) {
		super(label);
	}

	public int getLength() {
		return length;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public String getData() {
		return super.getData() + "\nPlasticBox [length- " + getLength() + " ,height- " + getHeight() + " ,width- "
				+ getWidth() + "]";
	}
}
