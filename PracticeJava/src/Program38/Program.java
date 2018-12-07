package Program38;

public class Program {
	public static Long sum = 0L;

	public static void main(String[] args) {
		SumAdd sa = new SumAdd();
		SumLess sl = new SumLess();
		Thread t1 = new Thread(sa, "First Thread");
		Thread t2 = new Thread(sl, "Second Thread");
		System.out.println(t1.getName());
		System.out.println(t2.getName());
			t1.start();
			t2.start();
			
			

	}
}
