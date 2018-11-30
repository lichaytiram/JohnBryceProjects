package Day28_11_2018;

public class Student {

	private String name;
	private int age;
	private int score;

	public Student(String name) {
		super();
		setName(name);
		setAge();
		setScore();

	}

	private int randomAge() {
		return (int) (Math.random() * 103) + 18;
	}

	private int randomScore() {
		return (int) (Math.random() * 101);
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

	public void setAge() {
		this.age = randomAge();
	}

	public int getScore() {
		return score;
	}

	public void setScore() {
		this.score = randomScore();
	}

	@Override
	public String toString() {
		return "Student [Name()=" + getName() + ", Age()=" + getAge() + ", Score()=" + getScore() + "]";
	}

}
