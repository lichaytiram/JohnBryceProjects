package Day05_11_2018_Project1;

public class Product {
	private String nameProduct;
	private int weight;

	public Product(String nameProduct, int weight) {
		this();
		this.nameProduct = nameProduct;
		this.weight = weight > 0 ? weight : 0;
	}

	public Product(Product product) {
		this();
		this.nameProduct = product.nameProduct;
		this.weight = product.weight;
	}

	public Product() {
		super();
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Product [nameProduct=" + getNameProduct() + ", weight=" + getWeight() + "]";
	}

}
