package Day29_05_2019;

public class Car implements Comparable<Car> {

	private String name;
	private double price;
	private String model;

	public Car(String name, double price, String model) {
		super();
		this.name = name;
		this.price = price;
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int compareTo(Car o) {
		if (o.getPrice() > this.price)
			return -1;
		else
			return 1;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", model=" + model + "]";
	}

}
