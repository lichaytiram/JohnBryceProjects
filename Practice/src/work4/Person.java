package work4;

public class Person {
	protected String name;
	protected int age;
	protected String id;

	public Person(String name, int age, String id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getId() {
		return id;
	}

	public String Print() {
		return "\nPerson [name - " + getName() + " ,age - " + getAge() + " ,id - " + getId() + "]";
	}
}
