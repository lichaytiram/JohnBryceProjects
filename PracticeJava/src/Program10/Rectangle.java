package Program10;

public class Rectangle {
	private int width;
	private int length;

	public Rectangle(int width, int length) {
		super();
		this.width = width;
		this.length = length;
	}

	public Rectangle() {
		width = 10;
		length = 10;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int Scope() {
		return 2 * length + 2 * width;
	}

	public int area() {
		return length * width;
	}

	public void print() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				if (i == 0 || j == 0 | i == width - 1 || j == length - 1)
					System.out.print("*");
				else
					System.out.print(" ");

			}
			System.out.println();
		}
	}
	
	public void print(char c) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				if (i == 0 || j == 0 | i == width - 1 || j == length - 1)
					System.out.print(c);
				else
					System.out.print(" ");

			}
			System.out.println();
		}
	}
}
