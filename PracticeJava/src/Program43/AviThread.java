package Program43;

public class AviThread extends Thread {

	private int id;

	public AviThread(int id) {
		this.id = id;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(this.id + " : " + i);
		}
	}

}
