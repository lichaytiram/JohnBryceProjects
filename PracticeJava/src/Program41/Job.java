package Program41;

public class Job implements Runnable {
	public static int number = 0;

	public void run() {
		while (true) {
			System.out.println("The time is: " + ++number);
			try {
				Thread.sleep(1000);
//				Thread.sleep(1000 * 60 * 60 * 24);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
