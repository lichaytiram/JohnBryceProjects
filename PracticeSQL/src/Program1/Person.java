package Program1;

public class Person {
	private String name;
	private int id;
	private int age;

	public Person(String name, int id, int age) {
		super();
		setName(name);
		setId(id);
		setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id > 0 ? id : -1;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age > 0 ? age : 0;
	}

	@Override
	public String toString() {
		return "Person [Name()=" + getName() + ", Id()=" + getId() + ", Age()=" + getAge() + "]";
	}
}