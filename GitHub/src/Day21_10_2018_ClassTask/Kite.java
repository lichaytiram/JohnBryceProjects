package Day21_10_2018_ClassTask;

public class Kite implements IFly{
	private String color;
	private int price;

	public Kite() {
		super();
		this.color = "blue";
		this.price = 20;
	}

	@Override
	public String toString() {
		return "Kite [color=" + color + ", price=" + price + "]";
	}

	@Override
	public void fly(int speed) {
		System.out.println("He fly speed of " + speed);
	}

	@Override
	public boolean land() {
		return false;
	}
}
