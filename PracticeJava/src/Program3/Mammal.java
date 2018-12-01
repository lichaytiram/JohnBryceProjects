package Program3;

public abstract class Mammal extends Animal {
	private int milkproduction;

	public Mammal(String name, String color, int age, int mp) {
		super(name, color, age);
		this.milkproduction = mp;
	}

	public int getMilkproduction() {
		return milkproduction;
	}

	public void setMilkproduction(int ml) {
		this.milkproduction = ml;
	}

}
