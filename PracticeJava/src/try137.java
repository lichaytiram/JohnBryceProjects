
public class try137 {
	public static void main(String[] args) {
		/*
		 * for (int i = 0; i < 5; i++) { System.out.println("hi"); try {
		 * Thread.sleep(1000); } catch (Exception e) {
		 * System.out.println(e.getMessage()); } }
		 */
		System.out.println("-------------------");
		System.out.println(Thread.currentThread().getName());
		long sum1 = 0;
		long sum2 = 0;
		long sum3 = 0;
		for (int i = 0; i < 2000000000L; i++)
			sum1 += i;
		System.out.println("Sum 1 is: " + sum1);
		for (int i = 0; i < 2000000000L; i++)
			sum2 += i;
		System.out.println("Sum 2 is: " + sum2);
		for (int i = 0; i < 2000000000L; i++)
			sum3 += i;
		System.out.println("Sum 3 is: " + sum3);
		System.out.println("Next step");
		System.out.println("End main");
	}
}
