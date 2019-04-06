package Program46;

public class Program {

	public static long number;

	public static void main(String[] args) throws InterruptedException {

		Add add = new Add();
		add.start();
		Thread.sleep(1);
		Less less = new Less();
		less.start();
		
	}

}
