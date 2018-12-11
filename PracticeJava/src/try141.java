import java.util.Date;

public class try141 {
	public static void main(String[] args) {
		System.out.println("Start");
		int x = 3;
		System.out.println(x);
		try {
			Thread.sleep(0L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(x);
		System.out.println("End");
		double d = 22.345678;
		System.out.println(d);
		System.out.println(String.format("", d));
		System.out.println(new Date());

	}
}
