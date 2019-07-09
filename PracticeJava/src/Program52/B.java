package Program52;

public class B extends A {

	private String s = "hello2";

	public B() {
		System.out.println("omg" + service() + s);
	}

	public static String service() {
		return "B service ";
	}

}
