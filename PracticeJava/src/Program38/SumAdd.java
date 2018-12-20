package Program38;

public class SumAdd implements Runnable {

	@Override
	public void run() {

		while (true) {
			try {
				synchronized (Program.sum) {
					Thread.sleep(1000);
					Program.sum++;
					System.out.println(Program.sum);
					System.out.println("before ADD");
					notify();
//					synchronized (Program.sum) {
//						Program.sum.wait();
//					}
					System.out.println("after ADD");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
