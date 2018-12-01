package Program6;

public class Program {
	public static void main(String[] args) {

		Cookie c1 = new Cookie(true, 3, 3, 4);
		Cookie c2 = new Cookie(false, 3, 3, 4);
		System.out.println(c1);
		System.out.println(c2);
		c1.setSuggar(12);
		System.out.println(c1);
		System.out.println(c2);
		c1=c2; // must deep copy
		System.out.println();
		System.out.println(c1);
		System.out.println(c2);
		
		c2.setSuggar(5);
		System.out.println(c1);
		System.out.println(c2);

	}
}
