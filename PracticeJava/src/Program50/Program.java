package Program50;

public class Program {

	public static long number;
	public static Object mutex = new Object();

	public static void main(String[] args) throws InterruptedException {

		Thread add = new Thread(new Add());
		Thread diminish = new Thread(new Diminish());

		add.start();
		diminish.start();

		add.join();
		diminish.join();

		System.out.println("The numbers is: " + number);
	}
}
