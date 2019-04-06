package Program45;

public class program {

	public static Long number = 0L;

	public static void main(String[] args) {

		Add add = new Add();
		Less less = new Less();

		add.start();

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		less.start();

	}

}
