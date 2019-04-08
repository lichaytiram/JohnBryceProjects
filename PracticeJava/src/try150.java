
public class try150 {

	public static int number;
	public static Object Mutex = new Object();

	public static void main(String[] args) {

		Thread thread1 = new Thread(() -> {

			for (int i = 0; i < 1000000; i++) {
				synchronized (Mutex) {
					number++;
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				synchronized (Mutex) {
					number++;
				}
			}
		});

		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(number);

	}
}
