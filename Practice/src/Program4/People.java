package Program4;

public class People {
	private String name;
	private int age;
	private Car car;

	public People(String name, int age, Car car) {
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Car getCar() {
		return car;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
