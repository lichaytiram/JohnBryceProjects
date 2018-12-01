package Program30;

public class Pizza implements Comparable<Pizza> {

	private toppings top;
	private Size si;
	private double price;

	public Pizza(toppings top, Size si, double price) {
		super();
		this.top = top;
		this.si = si;
		this.price = price;
	}

	public toppings getTop() {
		return top;
	}

	public void setTop(toppings top) {
		this.top = top;
	}

	public Size getSi() {
		return si;
	}

	public void setSi(Size si) {
		this.si = si;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Pizza p) {
		if (price > p.price)
			return 1;
		else if (price < p.price)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "Pizza [top=" + top + ", si=" + si + ", price=" + price + "]";
	}

}
