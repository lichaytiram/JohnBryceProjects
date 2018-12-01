package Program25;

public class privateCar extends Car {

	private int size;
	public int sizeAll;
	public static int s;

	public privateCar() {
		s++;
	}
	public void print() {
		System.out.println("ideal from dad @Override");
	}

	@Override
	public String toString() {
		return "privateCar [size=" + size + ", sizeAll=" + sizeAll + "] check? " + s;
	}

}
