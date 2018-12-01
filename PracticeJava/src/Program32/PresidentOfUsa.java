package Program32;

public class PresidentOfUsa {
	private String name;
	private String live;
	private int age;

	private PresidentOfUsa() {
		name = "null";
		live = "null";
		age = 0;
	}

	private static PresidentOfUsa instance = new PresidentOfUsa();

	public static PresidentOfUsa getInstance() {
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLive() {
		return live;
	}

	public void setLive(String live) {
		this.live = live;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PresidentOfUsa [name=" + name + ", live=" + live + ", age=" + age + "]";
	}

}
