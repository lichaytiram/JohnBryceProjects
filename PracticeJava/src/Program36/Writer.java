package Program36;

public class Writer implements Runnable {

	private String name;

	public Writer(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			synchronized (Program.stringList) {
				Program.stringList.add(this.name);
			}
			System.out.print("run: " + i + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
