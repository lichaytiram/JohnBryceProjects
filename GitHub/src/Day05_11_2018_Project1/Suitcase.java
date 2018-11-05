package Day05_11_2018_Project1;

import java.util.ArrayList;

public class Suitcase {

	private ArrayList<Product> product;
	private int allItems;

	public Suitcase() {
		super();
		this.product = new ArrayList<Product>();
		this.allItems = 0;
	}

	public void addProductToSuitcase(Product product) {
		this.product.add(product);
	}

	public void removeProductToSuitcase(Product product) {
		this.product.remove(product);
	}

	public ArrayList<Product> getProduct() {
		return product;
	}

	public int getAllItems() {
		return allItems;
	}

	@Override
	public String toString() {
		return "Suitcase [product=" + getProduct() + ", allItems=" + getAllItems() + "]";
	}

}
