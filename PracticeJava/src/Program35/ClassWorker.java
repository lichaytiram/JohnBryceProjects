package Program35;

public class ClassWorker implements Runnable {

	private String classTag;

	public ClassWorker(String classTag) {
		super();
		this.classTag = classTag;
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(classTag + ": " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
