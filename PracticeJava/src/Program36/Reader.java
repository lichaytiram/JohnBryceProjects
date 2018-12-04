package Program36;

public class Reader {

	public void read() {
		int size = Program.stringList.size();
		System.out.println("\nStart Reader");
		try {
			Thread.sleep(1000);
			for (int i = 0; i < size; i++)
				System.out.print(Program.stringList.get(i) + " ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nEnd Reader");
	}
}
