package Program35;

public class Program {
	public static void main(String[] args) {

		ClassWorker c = new ClassWorker("dor dori");
		Thread t1 = new Thread(c);

		t1.start();

	}
}
