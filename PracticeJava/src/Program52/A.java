package Program52;

public class A {

	private String s = "hello1";

	public A() {
		System.out.println(service() + s);
	}

	public static String service() {
		return "A service ";
	}
}
