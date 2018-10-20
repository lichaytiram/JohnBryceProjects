package Program13;

public class Program {
	public static void main(String[] args) {

		Lecturer l1 = new Lecturer("dod1", 10000);
		Lecturer l2 = new Lecturer("dod2", 1000);
		Lecturer l3 = new Lecturer("dod3", 100);
		Lecturer[] lArr = { l1, l2, l3 };
		Student s1 = new Student("dx1", 12345);
		Student s2 = new Student("dx2", 123456);
		Student s3 = new Student("dx3", 1234567);
		Student s4 = new Student("dx4", 12345678);
		Student s5 = new Student("dx5", 123);
		Student[] s = { s1, s2, s3, s4, s5 };
		Department d1 = new Department("math", lArr, s);
		Department d2 = new Department("sport", lArr, s);
		Department[] dArr = { d1, d2 };
		// System.out.println(d1);
		String[] sArr = { "math", "sport" };
		College c1 = new College(sArr, dArr);
		System.out.println(c1);
	}
}
