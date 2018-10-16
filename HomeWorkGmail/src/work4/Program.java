package work4;

public class Program {

	public static void main(String[] args) {
		Person p = new Person("adi", 22, "1234543253");
		System.out.println(p.Print());
		Worker w = new Worker("moshe", 23, "123356455", "goodle", 4);
		System.out.println(w.Print());
		Driver d = new Driver("koksh", 28, "1235564", "motorcycle", 45, "free to drive");
		System.out.println(d.Print());
	}
}
