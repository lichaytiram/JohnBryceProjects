package Program47;

public class Person {

	private String name;
	private double age;
	private boolean degree;

	public Person(String name, double age, boolean degree) {
		super();
		this.name = name;
		this.age = age;
		this.degree = degree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public boolean isDegree() {
		return degree;
	}

	public void setDegree(boolean degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", degree=" + degree + "]";
	}

}
