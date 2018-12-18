package Program38;

public class SumAdd implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {
			synchronized (Program.sum) {
				Program.sum++;
				System.out.println(Program.sum);
				try {
					System.out.println("before");
					Thread.sleep(1000);
					Program.sum.wait(2000);
					System.out.println("after");

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}
}
