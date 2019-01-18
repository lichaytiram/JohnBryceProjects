
public class try146 {
	public static void main(String[] args) {

		Car c1 = new Car("nissan", 70000);
		Car c2 = new Car("nissan", 85000);
		System.out.println(c1);
		System.out.println(c2);
	}
}

class Car {
	private String company;
	private int price;

	/**
	 * ..
	 * @param company .. etc
	 * @param price   .. etc
	 */
	public Car(String company, int price) {
		super();
		this.company = company;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", price=" + price + "]";
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
