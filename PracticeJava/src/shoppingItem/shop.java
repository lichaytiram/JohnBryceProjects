package shoppingItem;

public class shop {
	String descripition, shippingMethod;
	int price, quantity;

	public shop(String descripition, String shippingMethod, int price, int quantity) {
		this.descripition = descripition;
		this.shippingMethod = shippingMethod;
		this.price = price;
		this.quantity = quantity;
	}

	public shop(String descripition, String shippingMethod, int price) {
		this.descripition = descripition;
		this.shippingMethod = shippingMethod;
		this.price = price;
		this.quantity = 1;
	}
	public int calculateFinalPrice() {
		return price*quantity;
	}

	public String printInfo() {
		return "descripition " + descripition + " ,shippingMethod " + shippingMethod + " ,price " + price
				+ " ,quantity " + quantity+" ,FinalPrice "+calculateFinalPrice();
	}

}
