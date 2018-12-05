package Program37;

public class Program {
	public static void main(String[] args) {

		Person p1 = new Person(123456, "dori", 12);
		Person p2 = new Person(123456, "moshe", 88);
		Person p3 = new Person(123456, "ronen", 43);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(Person.sum);
		System.out.println(Person.sum);

	}
}
