package Program46;

public class Less extends Thread {

	@Override
	public void run() {

		while (true) {

			System.out.println(Program.number);
			Program.number--;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
