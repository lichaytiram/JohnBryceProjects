package Program34;

public class Cat extends Animal implements IIsBite {
	private int timesLick;
	private EColor color;

	public Cat(String name, int age, EColor color) {
		super(name, age);
		this.timesLick = 0;
		this.color = color;
	}

	public EColor getColor() {
		return color;
	}

	public int getTimesLick() {
		return timesLick;
	}

	public void lick() {
		timesLick++;
	}

	@Override
	public String isBite() {
		return "Maybe Once a year";
	}

	@Override
	public String toString() {
		return super.toString() + "Cat [Color()=" + getColor() + ", TimesLick()=" + getTimesLick() + "]\n";
	}

}
