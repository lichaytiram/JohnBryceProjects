package Program20;

public abstract class Animal {
	private String name;
	private boolean isVegetarian;
	private int numberOfLeg;

	public Animal(String name, boolean isVegetarian, int numberOfLeg) {
		super();
		this.name = name;
		this.isVegetarian = isVegetarian;
		this.numberOfLeg = numberOfLeg > 0 ? numberOfLeg : 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}

	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public int getNumberOfLeg() {
		return numberOfLeg;
	}

	public void setNumberOfLeg(int numberOfLeg) {
		this.numberOfLeg = numberOfLeg > 0 ? numberOfLeg : 0;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", isVegetarian=" + isVegetarian + ", numberOfLeg=" + numberOfLeg + "]";
	}

}
