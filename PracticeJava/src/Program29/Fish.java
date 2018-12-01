package Program29;

public class Fish implements IsWalk, IsLive {

	private int age;
	private int deepswim;

	public Fish(int age, int deepswim) {
		super();
		this.age = age;
		this.deepswim = deepswim;
	}

	public void walk() {
		System.out.println("can't  walk");
	}

	public boolean isWalk() {
		return false;
	}

	public boolean isLive() {
		return true;
	}

	@Override
	public String toString() {
		return "Fish [age=" + age + ", deepswim=" + deepswim + "]";
	}

}
