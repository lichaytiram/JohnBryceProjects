package Program38;

public class SumLess implements Runnable {
	long sum = Program.sum;

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Program.sum--;

	}

}
