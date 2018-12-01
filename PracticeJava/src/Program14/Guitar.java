package Program14;

public abstract class Guitar {
	private static int serials = 0;
	private String company;
	private int price;
	private final int serial = serials;

	public Guitar(String company, int price) {
		super();
		this.company = company;
		this.price = price > 0 ? price : 0;
		serials++;
	}

	@Override
	public String toString() {
		return "Serial number " + serial + " Guitar [company=" + company + ", price=" + price + "]";
	}

}
