package Day10_10_2018_Pizza;

public class Pizza {

	private int diameter;
	private int slices;
	private int toppings;
	private static int SumToppings = 0;

	public Pizza(int diameter, int slices, int toppings) {
		super();
		this.diameter = diameter;
		this.slices = slices;
		this.toppings = toppings;
		SumToppings += toppings;
	}

	public Pizza() {
		super();
		this.diameter = (int) (Math.random() * 40 + 10);
		this.slices = (int) (Math.random() * 7 + 1);
		this.toppings = (int) (Math.random() * 5);
		SumToppings += toppings;

	}

	public static int getSumToppings() {
		return SumToppings;
	}

	public boolean isBasicPizza() {
		return (toppings > 0) ? false : true;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getSlices() {
		return slices;
	}

	public void setSlices(int slices) {
		this.slices = slices;
	}

	public int getToppings() {
		return toppings;
	}

	public void setToppings(int toppings) {
		this.toppings = toppings;
	}

	public String print() {
		return "Pizza [diameter=" + getDiameter() + ", slices=" + getSlices() + ", toppings=" + getToppings() + "]";
	}

}
