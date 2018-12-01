package Program34;

public class Dog extends Animal implements IIsBite {
	private int numberOfLeg;

	public Dog(String name, int age, int numberOfLeg) {
		super(name, age);
		setNumberOfLeg(numberOfLeg);
	}

	public int getNumberOfLeg() {
		return numberOfLeg;
	}

	public void setNumberOfLeg(int numberOfLeg) {
		this.numberOfLeg = numberOfLeg > 4 || numberOfLeg < 0 ? 0 : numberOfLeg;
	}

	@Override
	public String isBite() {
		return "The dog is bite";
	}

	@Override
	public String toString() {
		return super.toString() + "Dog [NumberOfLeg()=" + getNumberOfLeg() + "]\n";
	}

}
