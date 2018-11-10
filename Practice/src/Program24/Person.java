package Program24;

public class Person {
	private final int id;
	private String name;

	public Person(String name) {
		super();
		this.id = (int) (Math.random() * 1000) + 1;
		this.name = name;
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
