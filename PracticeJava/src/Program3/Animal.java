package Program3;

public abstract class Animal {
	private String name;
	private String color;
	private int age;

//  constructor
	public Animal(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}

//  getter and setter
	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
