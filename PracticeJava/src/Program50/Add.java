package Program50;

public class Add implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 20000; i++)
			synchronized (Program.mutex) {
				Program.number++;
			}

		System.out.println(Program.number);

	}

}
