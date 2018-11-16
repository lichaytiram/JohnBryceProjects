package Program27;

public class DodelCompany {
	private String name;
	private String date;
	private int price;

	public DodelCompany(String name, String date, int price) {
		super();
		this.name = name;
		this.date = date;
		this.price = price = price > 20000 ? price : 20000;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "DodelCompany [name=" + getName() + ", date=" + getDate() + ", price=" + getPrice() + "$]";
	}

}
