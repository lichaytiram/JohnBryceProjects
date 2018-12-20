package Program38;

public class SumLess implements Runnable {

	@Override
	public void run() {

		while (true) {
			try {
				synchronized (Program.sum) {
					Thread.sleep(1000);
					Program.sum++;
					System.out.println(Program.sum);
					System.out.println("before LESS");
					notify();
//					synchronized (Program.sum) {
//						Program.sum.wait();
//					}
					System.out.println("after LESS");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
