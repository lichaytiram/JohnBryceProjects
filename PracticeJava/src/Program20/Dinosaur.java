package Program20;

public class Dinosaur extends Animal {
	private int height;

	public Dinosaur(String name, int height) {
		super(name, false, 4);
		this.height = height > 0 ? height : 0;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height > 0 ? height : 0;
	}

	@Override
	public String toString() {
		return super.toString() + "\nDinosaur [height=" + height + "]\n";
	}

}
