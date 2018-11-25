package work6;

public class Control {

	protected int placeX, placeY;
	protected int height, width;
	protected String label;

	public Control(int placeX, int placeY, int height, int width, String label) {
		super();
		this.placeX = placeX;
		this.placeY = placeY;
		this.height = height;
		this.width = width;
		this.label = label;
	}

	public int getPlaceX() {
		return placeX;
	}

	public int getPlaceY() {
		return placeY;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public String getLabel() {
		return label;
	}

	public String Draw() {
		return "\nControl [getPlaceX()=" + getPlaceX() + ", getPlaceY()=" + getPlaceY() + ", getLabel()=" + getLabel()
				+ "]";
	}

}
