package Day14_10_2018_Student;


public class Program {
	public static void main(String[] args) {
		Student s1 = new Student(80, 25);
		System.out.println(s1);
		System.out.println("Student- " + Student.student + "--> " + Student.getAvarageAge());
		Student s2 = new Student(100, 20);
		System.out.println(s2);
		System.out.println("Student- " + Student.student + "--> " + Student.getAvarageGrade());

	}
}