package Program45;

public class Add extends Thread {

	@Override
	public void run() {

		while (true) {

			synchronized (program.number) {
				System.out.println(program.number);
				program.number++;
			}

			try {

				Thread.sleep(10);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
