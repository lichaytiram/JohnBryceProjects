
public class try136 {
	private static long sum1 = 0;
	private static long sum2 = 0;
	private static long sum3 = 0;

	public static void main(String[] args) {
		/*
		 * for (int i = 0; i < 5; i++) { System.out.println("hi"); try {
		 * Thread.sleep(1000); } catch (Exception e) {
		 * System.out.println(e.getMessage()); } }
		 */
		System.out.println("-------------------");
		System.out.println(Thread.currentThread().getName());

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2000000000L; i++)
					sum2 += i;
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2000000000L; i++)
					sum3 += i;
			}
		});
		t1.start();
		t2.start();
		System.out.println("Sum 2 is: " + sum2);
		for (int i = 0; i < 2000000000L; i++)
			sum1 += i;
		System.out.println("Sum 3 is: " + sum3);
		System.out.println("Sum 1 is: " + sum1);
		System.out.println("Next step");
		System.out.println("End main");
		try {
			Thread.sleep(2000);
			System.out.println("sleep");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hi");
	}
}
