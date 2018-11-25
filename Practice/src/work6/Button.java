package work6;

public class Button extends Control {

	protected String color;

	public Button(int placeX, int placeY, int height, int width, String label, String color) {
		super(placeX, placeY, height, width, label);
		this.color = color;
		for (int i = 0; i < height; i++) {
			System.out.print("*" + " ");
		}
		int count = 0;
		for (int i = 0; i < height; i++) {

			if (i == 0)
				System.out.print("\n* " + label);
			else {
				System.out.print(" ");
			}
			if (count == height/2-1)
				System.out.print("*");
			count++;
		}
		System.out.println();
		for (int i = 0; i < height; i++) {
			System.out.print("*" + " ");
		}
	}

	public String getColor() {
		return color;
	}

	public String Draw() {
		return super.Draw() + "\nButton [getColor()=" + getColor() + "]";
	}

}
