package Program29;

public class Robot implements IsWalk {
	private String name;
	private boolean isKnowFly;

	public Robot(String name, boolean isKnowFly) {
		super();
		this.name = name;
		this.isKnowFly = isKnowFly;
	}

	public void walk() {
		System.out.println("yes it is!\nHis name is: " + name);
	}

	public boolean isWalk() {
		return true;
	}

	@Override
	public String toString() {
		return "Robot [name=" + name + ", isKnowFly=" + isKnowFly + "]";
	}

}
