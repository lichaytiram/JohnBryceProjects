package work3;

public class Program {

	public static void main(String[] args) {
		Box b1 = new Box(5, 5, 5);
		Box b2 = new Box(2, 3, 4);
		Box b3 = new Box(25);
		System.out.println(b1.area());
		System.out.println(b2.area());
		System.out.println(b3.area());
		System.out.println("max is");
		b1.printmax(100);
		b2.printmax(100);
		b3.printmax(100);
		
	}
}
