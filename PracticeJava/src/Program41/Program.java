package Program41;

public class Program {
	public static void main(String[] args) {
		Job j = new Job();
		Thread t1 = new Thread(j, "daily job");
		System.out.println(t1.getName());
		t1.start();
	}
}
