package Program37;

public class Person implements Runnable {
	private int id;
	private String name;
	private int age;
	public static long sum;

	public Person(int id, String name, int age) {
		super();
		setId(id);
		setName(name);
		setAge(age);
		sum++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id > 0 ? id : 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age > 0 ? age : 0;
	}

	@Override
	public void run() {
			sum++;
		
	}

	@Override
	public String toString() {
		return "Person [Id()=" + getId() + ", Name()=" + getName() + ", Age()=" + getAge() + "]";
	}

}
