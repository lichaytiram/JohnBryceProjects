package Program33;

public class AnonymousClass {

	private String name;
	private int age;

	public AnonymousClass(String name, int age) {
		this.name = name;
		this.age = age;
	}

	static {};

	public String getName() {
		if (name.charAt(0) < 'a')
			return name;
		return (char) (name.charAt(0) - 32) + name.substring(1, name.length());
	}

	@Override
	public String toString() {
		return "AnonymousClass [name=" + getName() + ", age=" + age + "]";
	}

}
