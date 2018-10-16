package Program4;

public class Car {
	private int price;
	private String color;
	private String company;

	public Car(int price, String color, String company) {
		this.price = price;
		this.color = color;
		this.color = company;
	}

	public String getPrice() {
		return price+",000$";
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
}
