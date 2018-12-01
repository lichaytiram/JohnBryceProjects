package Program7;

public class Program {
	public static void main(String[] args) {
		Clock c1 = new Clock(22, 30, 59);
		System.out.println(c1.show());
		c1.tick();
		c1.tick();
		System.out.println(c1.show());
		c1.reset();
		System.out.println(c1.show());
	}
}
