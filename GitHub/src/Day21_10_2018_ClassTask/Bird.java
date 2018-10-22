package Day21_10_2018_ClassTask;

public class Bird implements IFly {
	private String kind;
	private int age;
	private String color;

	public Bird() {
		super();
		this.kind = "nahlieli";
		this.age = 3;
		this.color = "white";
	}

	@Override
	public String toString() {
		return "Bird [kind=" + kind + ", age=" + age + ", color=" + color + "]";
	}

	@Override
	public void fly(int speed) {
		System.out.println("He fly speed of " + speed);
	}

	@Override
	public boolean land() {
		return true;
	}

}
