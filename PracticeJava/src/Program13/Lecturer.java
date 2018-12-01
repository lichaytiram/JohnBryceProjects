package Program13;

public class Lecturer {
	private String name;
	private int salary;

	public Lecturer(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "\nLecturer [name=" + name + ", salary=" + salary + "]";
	}

}
