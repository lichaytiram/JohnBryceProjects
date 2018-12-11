package Program39;

public class Program implements Iinter {

	public static void main(String[] args) {
		System.out.println("run");
		Iinter e = new Iinter() {
		};
		System.out.println(e.try1(3));
		Iinter.try2();
	}

}
