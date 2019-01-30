package HM1;

import java.util.Arrays;

public class Dress {
	private String manufacturer;
	private String model;
	private String type;

	private double price;
	private String size;

	private String[] color;

	public Dress(String manufacturer, String model, String type, double price, String size, String[] color) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.type = type;
		this.price = price;
		this.size = size;
		this.color = color;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String producer) {
		this.manufacturer = producer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return Arrays.toString(color);
	}

	public void setColor(String[] color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dress [manufacturer=" + manufacturer + ", model=" + model + ", type=" + type + ", price=" + price
				+ ", size=" + size + ", color=" + Arrays.toString(color) + "]";
	}

}
