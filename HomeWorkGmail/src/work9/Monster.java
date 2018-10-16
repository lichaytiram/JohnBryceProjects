package work9;

public class Monster {

	protected String name;

	public Monster(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String attack() {
		return "I cannot attack";
	}

}
