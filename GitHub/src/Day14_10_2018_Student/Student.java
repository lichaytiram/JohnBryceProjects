package Day14_10_2018_Student;

public class Student {

	public static int sumgrade = 0;
	public static int sumage = 0;
	public static int student = 0;
	private int grade;
	private int age;

	public Student(int grade, int age) {
		super();
		this.grade = grade;
		this.age = age;
		sumgrade += grade;
		sumage += age;
		student++;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static double getAvarageGrade() {
		return (double) sumgrade / student;
	}

	public static double getAvarageAge() {
		return (double) sumage / student;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", age=" + age + "]";
	}

}