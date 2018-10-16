package work6;

public class TextBox extends Control {

	protected int maxLabel;

	public TextBox(int placeX, int placeY, int height, int width, String label, int maxLabel) {
		super(placeX, placeY, height, width, label);
		this.maxLabel = maxLabel;
	}

	public int getMaxLabel() {
		return maxLabel;
	}

}
