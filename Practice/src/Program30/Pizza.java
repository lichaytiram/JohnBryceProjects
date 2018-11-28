package Program30;

public class Pizza {

	private toppings top;
	private Size si;
	private double price;

	public Pizza(toppings top, Size si, double price) {
		super();
		this.top = top;
		this.si = si;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pizza [top=" + top + ", si=" + si + ", price=" + price + "]";
	}

}
