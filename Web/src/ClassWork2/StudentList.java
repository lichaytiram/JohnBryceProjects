package ClassWork2;

import java.util.ArrayList;

public class StudentList {

	Student s1 = new Student(1, "Bob", 20, 100);
	Student s2 = new Student(2, "Alice", 21, 70);
	Student s3 = new Student(3, "Tom", 40, 95);
	Student s4 = new Student(4, "Talia", 18, 100);
	Student s5 = new Student(5, "Nil", 20, 100);
	public ArrayList<Student> list = null;

	public static StudentList getInstance() {
		return instance;
	}

	public static StudentList instance = new StudentList();

	private StudentList() {
		list = new ArrayList<StudentList.Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
	}

	public class Student {
		private int id;
		private String name;
		private double age;
		private double grade;

		public Student(int id, String name, double age, double grade) {
			super();
			setId(id);
			setName(name);
			setAge(age);
			setGrade(grade);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public double getGrade() {
			return grade;
		}

		public void setGrade(double grade) {
			this.grade = grade;
		}

		@Override
		public String toString() {
			return "Student [id=" + getId() + ", name=" + getName() + ", age=" + getAge() + ", grade=" + getGrade()
					+ "]";
		}

	}
}
