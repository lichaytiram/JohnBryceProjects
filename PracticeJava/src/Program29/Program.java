package Program29;

public class Program {
	public static void main(String[] args) {

		Fish f1 = new Fish(21, 42);
		f1.walk();
		System.out.println(f1.isWalk());
		System.out.println(f1.isLive());
		Robot r1 = new Robot("rogi", true);
		r1.walk();
	}
}
