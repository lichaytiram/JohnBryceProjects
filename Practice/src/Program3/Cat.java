package Program3;

public class Cat extends Mammal {
	private String bad;

	public Cat(String name, String color, int age, int mp, String bad) {
		super(name, color, age, mp);
		this.bad = bad;
	}

	public String getBad() {
		return bad;
	}

	public void setBad(String bad) {
		this.bad = bad;
	}

}
