package Program13;

public class Student {
	private String name;
	private int id;

	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nStudent [name=" + name + ", id=" + id + "]";
	}

}
