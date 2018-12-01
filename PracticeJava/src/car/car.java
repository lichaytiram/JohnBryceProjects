package car;

public class car {
	public int price, maxspeed;
	public String company, color;
	public int setprice;

	public void setprice(int price) {
		this.price = price;
	}
	public car(int price,int maxspeed,String color,String company) {
		this.color=color;
		this.price=price;
		this.company=company;
		this.maxspeed=maxspeed;
	}

	public String toString() {
		return color + "\n" + company + "\n" + price + "\n" + maxspeed;
	}
}
